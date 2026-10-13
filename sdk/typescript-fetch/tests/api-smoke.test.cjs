const assert = require('node:assert/strict');
const fs = require('node:fs');
const path = require('node:path');
const test = require('node:test');

const { CarApi, Configuration, UserApi } = require('timr-api');

test('plain options supply defaults and read the current token for every request', async () => {
  let token = 'Bearer first-token';
  const requests = [];
  const api = new UserApi({
    accessToken: () => token,
    fetchApi: async (url, init) => {
      requests.push({ url, init });
      return new Response(JSON.stringify({ next_page_token: null, data: [] }), {
        headers: { 'Content-Type': 'application/json' }
      });
    }
  });

  await api.fetchUsers({ limit: 10 });
  token = 'Bearer refreshed-token';
  await api.fetchUsers({ limit: 20 });

  assert.equal(requests[0].url, 'https://api.timr.com/v1/users?limit=10');
  assert.equal(requests[1].url, 'https://api.timr.com/v1/users?limit=20');
  assert.equal(requests[0].init.headers.Authorization, 'Bearer first-token');
  assert.equal(requests[1].init.headers.Authorization, 'Bearer refreshed-token');
});

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

  const user = await api.getUser('user123');

  assert.equal(user.id, 'user123');
  assert.equal(user.fullname, 'John Doe');
  assert.equal(request.url, 'https://example.test/v1/users/user123');
  assert.equal(request.init.method, 'GET');
  assert.equal(request.init.headers.Authorization, 'Bearer token-abc');
});

test('createCar accepts the body directly and serializes model properties', async () => {
  let request;
  const api = new CarApi(new Configuration({
    basePath: 'https://example.test/v1',
    accessToken: 'Bearer token-abc',
    fetchApi: async (url, init) => {
      request = { url, init };
      return new Response(JSON.stringify({
        id: 'car123', name: 'Company car', plate: 'LL-123AB',
        external_id: 'fleet123', usable: true
      }), { status: 201, headers: { 'Content-Type': 'application/json' } });
    }
  }));

  const car = await api.createCar({
    name: 'Company car', plate: 'LL-123AB', externalId: 'fleet123'
  });

  assert.equal(request.url, 'https://example.test/v1/cars');
  assert.equal(request.init.method, 'POST');
  assert.equal(request.init.headers.Authorization, 'Bearer token-abc');
  assert.deepEqual(JSON.parse(request.init.body), {
    name: 'Company car', plate: 'LL-123AB', external_id: 'fleet123'
  });
  assert.equal(car.id, 'car123');
  assert.equal(car.externalId, 'fleet123');
});

test('updateCar accepts an ID and body separately and encodes the path', async () => {
  let request;
  const api = new CarApi(new Configuration({
    basePath: 'https://example.test/v1',
    fetchApi: async (url, init) => {
      request = { url, init };
      return new Response(JSON.stringify({
        id: 'car/123', name: 'Company car', plate: 'LL-456CD',
        external_id: null, usable: true
      }), { headers: { 'Content-Type': 'application/json' } });
    }
  }));

  const car = await api.updateCar('car/123', { plate: 'LL-456CD' });

  assert.equal(request.url, 'https://example.test/v1/cars/car%2F123');
  assert.equal(request.init.method, 'PATCH');
  assert.deepEqual(JSON.parse(request.init.body), { plate: 'LL-456CD' });
  assert.equal(car.plate, 'LL-456CD');
});

test('fetchCars serializes named filters and pagination', async () => {
  let requestUrl;
  const api = new CarApi(new Configuration({
    basePath: 'https://example.test/v1',
    fetchApi: async (url) => {
      requestUrl = new URL(url);
      return new Response(JSON.stringify({ next_page_token: null, data: [] }), {
        headers: { 'Content-Type': 'application/json' }
      });
    }
  }));

  const page = await api.fetchCars({ nameOrPlate: 'Company car', usable: true, pageToken: 'next page', limit: 10 });

  assert.equal(requestUrl.pathname, '/v1/cars');
  assert.equal(requestUrl.searchParams.get('name_or_plate'), 'Company car');
  assert.equal(requestUrl.searchParams.get('usable'), 'true');
  assert.equal(requestUrl.searchParams.get('page_token'), 'next page');
  assert.equal(requestUrl.searchParams.get('limit'), '10');
  assert.deepEqual(page, { nextPageToken: null, data: [] });
});

test('fetchCars accepts a later query parameter without placeholders', async () => {
  let requestUrl;
  const api = new CarApi(new Configuration({
    basePath: 'https://example.test/v1',
    fetchApi: async (url) => {
      requestUrl = new URL(url);
      return new Response(JSON.stringify({ next_page_token: null, data: [] }), {
        headers: { 'Content-Type': 'application/json' }
      });
    }
  }));

  await api.fetchCars({ pageToken: 'next page' });

  assert.deepEqual([...requestUrl.searchParams], [['page_token', 'next page']]);
});

test('fetchCars permits omitting optional query options', async () => {
  let requestUrl;
  const api = new CarApi(new Configuration({
    basePath: 'https://example.test/v1',
    fetchApi: async (url) => {
      requestUrl = new URL(url);
      return new Response(JSON.stringify({ next_page_token: null, data: [] }), {
        headers: { 'Content-Type': 'application/json' }
      });
    }
  }));

  await api.fetchCars();

  assert.equal(requestUrl.search, '');
});

test('path arguments stay separate from query options and HTTP overrides', async () => {
  let request;
  const api = new UserApi(new Configuration({
    basePath: 'https://example.test/v1',
    fetchApi: async (url, init) => {
      request = { url: new URL(url), init };
      return new Response(JSON.stringify({ next_page_token: null, data: [] }), {
        headers: { 'Content-Type': 'application/json' }
      });
    }
  }));

  await api.fetchUserTeamMemberships('user/123', { pageToken: 'next page', limit: 10 }, {
    headers: { 'X-Request-ID': 'request123' }
  });

  assert.equal(request.url.pathname, '/v1/users/user%2F123/team-memberships');
  assert.equal(request.url.searchParams.get('page_token'), 'next page');
  assert.equal(request.url.searchParams.get('limit'), '10');
  assert.equal(request.init.headers['X-Request-ID'], 'request123');
});
