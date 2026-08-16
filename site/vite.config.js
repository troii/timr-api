import { defineConfig } from 'vite'

// The site is served from https://troii.github.io/timr-api/ until developers.timr.com is pointed at
// Pages; set this back to '/' when it is, together with the redirect URI in spec/overlay.yaml.
export default defineConfig({
  base: '/timr-api/',
})
