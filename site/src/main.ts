import { createApiReference } from '@scalar/api-reference'
// The CDN build injects its styles; the bundled build needs them imported.
import '@scalar/api-reference/style.css'
import './theme.css'

createApiReference('#app', {
  url: `${import.meta.env.BASE_URL}openapi.yaml`,
  // Requests go straight to the API. Requires CORS on api.timr.com for this origin, including an
  // explicit Authorization in Access-Control-Allow-Headers — a wildcard does not cover it.
  proxyUrl: null,
  hideModels: true,
})
