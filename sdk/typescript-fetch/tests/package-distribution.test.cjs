const assert = require('node:assert/strict');
const { execFileSync } = require('node:child_process');
const fs = require('node:fs');
const os = require('node:os');
const path = require('node:path');
const { after, before, test } = require('node:test');

const packageRoot = path.resolve(__dirname, '..');
let consumer;

before(() => {
  consumer = fs.mkdtempSync(path.join(os.tmpdir(), 'timr-package-'));
  execFileSync('npm', [
    'pack', '--ignore-scripts', '--pack-destination', consumer
  ], { cwd: packageRoot, stdio: 'pipe' });
  const archives = fs.readdirSync(consumer).filter(filename => filename.endsWith('.tgz'));
  assert.equal(archives.length, 1);
  fs.writeFileSync(path.join(consumer, 'package.json'), JSON.stringify({ private: true }));
  execFileSync('npm', [
    'install', '--ignore-scripts', '--no-audit', '--no-fund', path.join(consumer, archives[0])
  ], { cwd: consumer, stdio: 'pipe' });
});

after(() => {
  if (consumer) fs.rmSync(consumer, { recursive: true, force: true });
});

for (const format of ['commonjs', 'esm']) {
  test(`installed package supports native ${format} requests`, () => {
    const load = format === 'commonjs'
      ? "const { UserApi } = require('timr-api'); assert.match(require.resolve('timr-api'), /\\.cjs$/);"
      : "import { UserApi } from 'timr-api'; assert.match(import.meta.resolve('timr-api'), /\\.mjs$/);";
    const source = `
      ${format === 'commonjs' ? "const assert = require('node:assert/strict');" : "import assert from 'node:assert/strict';"}
      ${load}
      (async () => {
        let request;
        const api = new UserApi({
          basePath: 'https://example.test/v1',
          accessToken: 'Bearer package-token',
          fetchApi: async (url, init) => {
            request = { url, init };
            return new Response(JSON.stringify({ id: 'user123', fullname: 'Package user' }), {
              headers: { 'Content-Type': 'application/json' }
            });
          }
        });
        const user = await api.getUser('user123');
        assert.equal(request.url, 'https://example.test/v1/users/user123');
        assert.equal(request.init.headers.Authorization, 'Bearer package-token');
        assert.equal(user.fullname, 'Package user');
      })().catch(error => { console.error(error); process.exitCode = 1; });
    `;
    const filename = path.join(consumer, `request.${format === 'commonjs' ? 'cjs' : 'mjs'}`);
    fs.writeFileSync(filename, source);
    execFileSync(process.execPath, [filename], { cwd: consumer, stdio: 'pipe' });
  });
}

test('installed declarations preserve the public calling conventions in both formats', () => {
  const source = fs.readFileSync(path.join(__dirname, 'api-types.ts'), 'utf8');
  for (const extension of ['cts', 'mts']) {
    const filename = path.join(consumer, `types.${extension}`);
    fs.writeFileSync(filename, source);
    execFileSync(path.join(packageRoot, 'node_modules', '.bin', 'tsc'), [
      '--ignoreConfig', '--noEmit', '--strict', '--target', 'es2022',
      '--module', 'nodenext', '--moduleResolution', 'nodenext', '--lib', 'es2022,dom', filename
    ], { cwd: consumer, stdio: 'pipe' });
  }
});

test('a browser bundler consumes the installed ESM package', async () => {
  const { build } = await import('tsdown');
  const entry = path.join(consumer, 'browser.ts');
  fs.writeFileSync(entry, `
    import { UserApi } from 'timr-api';
    export async function fetchUser() {
      const api = new UserApi({
        basePath: 'https://example.test/v1',
        fetchApi: async () => new Response(JSON.stringify({ id: 'user123', fullname: 'Browser user' }), {
          headers: { 'Content-Type': 'application/json' }
        })
      });
      return (await api.getUser('user123')).fullname;
    }
  `);
  const outDir = path.join(consumer, 'bundle');
  await build({
    config: false,
    cwd: consumer,
    entry: [entry],
    format: ['esm'],
    platform: 'browser',
    target: 'es2015',
    fixedExtension: true,
    dts: false,
    deps: { alwaysBundle: ['timr-api'], onlyBundle: ['timr-api'] },
    outDir,
    logLevel: 'silent',
  });
  const bundle = require('node:url').pathToFileURL(path.join(outDir, 'browser.mjs')).href;
  const result = execFileSync(process.execPath, ['--input-type=module', '-e', `
    import { fetchUser } from ${JSON.stringify(bundle)};
    console.log(await fetchUser());
  `], { cwd: consumer, encoding: 'utf8' });
  assert.equal(result.trim(), 'Browser user');
});
