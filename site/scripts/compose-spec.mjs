// Builds the specification the documentation renders: applies the overlay, then folds the guides in
// `guides/` in as tags that carry prose but no operations, grouped ahead of the API itself. The
// reader then moves between a guide and an endpoint inside one navigation instead of crossing into a
// separate site.
//
// The guides stay ordinary Markdown files in this repository; only the published copy of the
// specification carries them, never the contract.
import { spawnSync } from 'node:child_process'
import { readFile, writeFile, readdir } from 'node:fs/promises'
import { basename, join } from 'node:path'
import { parse, stringify } from 'yaml'

const [baseSpec, overlay, guidesDir, output] = process.argv.slice(2)

// bump-cli reports an action that matches nothing as a warning and exits 0. Treat it as an error, the
// way the SDK build does: a silently skipped action is how an overlay drifts away from the contract
// it patches.
const bump = spawnSync('bump', ['overlay', baseSpec, overlay], {
  encoding: 'utf8',
  maxBuffer: 64 * 1024 * 1024,
})
if (bump.status !== 0) {
  throw new Error(`bump overlay failed:\n${bump.stderr}`)
}
const unmatched = [...bump.stderr.matchAll(/Action target '(.+?)' has no matching elements/g)].map((m) => m[1])
if (unmatched.length) {
  throw new Error(`${overlay} targets nothing:\n  ${unmatched.join('\n  ')}`)
}

const files = (await readdir(guidesDir)).filter((f) => f.endsWith('.md')).sort()
const guides = await Promise.all(
  files.map(async (file) => {
    const source = await readFile(join(guidesDir, file), 'utf8')
    const match = source.match(/^#\s+(.+?)\r?\n(.*)$/s)
    if (!match) {
      throw new Error(`${file} must start with a level one heading naming the guide`)
    }
    return { name: match[1].trim(), description: match[2].trim(), file: basename(file) }
  }),
)

const spec = parse(bump.stdout)
const apiTags = (spec.tags ?? []).map((tag) => tag.name)

const clash = guides.find((guide) => apiTags.includes(guide.name))
if (clash) {
  throw new Error(`Guide "${clash.name}" (${clash.file}) collides with a tag of the same name`)
}

spec.tags = [...guides.map(({ name, description }) => ({ name, description })), ...(spec.tags ?? [])]
// theme.css unclamps the guides by matching the group's slug, so renaming this group renames the
// selector too.
spec['x-tagGroups'] = [
  { name: 'Guides', tags: guides.map((guide) => guide.name) },
  { name: 'API', tags: apiTags },
]

await writeFile(output, stringify(spec, { lineWidth: 0 }))
console.log(`composed ${output}: ${guides.length} guides, ${apiTags.length} API tags`)
