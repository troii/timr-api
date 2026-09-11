const assert = require('node:assert/strict');
const fs = require('node:fs');
const path = require('node:path');
const test = require('node:test');

const { Configuration, UserApi } = require('../dist');

test('authenticated request reaches the endpoint and decodes its response', async () => {
  const responseBody = fs.readFileSync(
    path.join(__dirname, '..', '..', 'test-fixtures', 'user.json'),
    'utf8'
  );
  let request;
  const api = new UserApi(new Configuration({
    basePath: 'https://example.test/v1',
    accessToken: 'Bearer token-abc',
    fetchApi: async (url, init) => {
      request = { url, init };
      return new Response(responseBody, {
        status: 200,
        headers: { 'Content-Type': 'application/json' }
      });
    }
  }));

  const user = await api.getUser({ id: 'user123' });

  assert.equal(user.id, 'user123');
  assert.equal(user.fullname, 'John Doe');
  assert.equal(request.url, 'https://example.test/v1/users/user123');
  assert.equal(request.init.method, 'GET');
  assert.equal(request.init.headers.Authorization, 'Bearer token-abc');
});
