import { CarApi, UserApi } from '../dist';

const cars = new CarApi();
const users = new UserApi();

cars.getCar('CAR_ID');
cars.createCar({ name: 'Company car', plate: 'LL-123AB' });
cars.updateCar('CAR_ID', { plate: 'LL-456CD' });
cars.fetchCars();
cars.fetchCars({ pageToken: 'PAGE_TOKEN', limit: 10 });
cars.fetchCars(undefined, { headers: { 'X-Request-ID': 'request123' } });
users.fetchUserTeamMemberships('USER_ID');
users.fetchUserTeamMemberships('USER_ID', { pageToken: 'PAGE_TOKEN' });
users.fetchUserTeamMemberships('USER_ID', { limit: 10 }, { credentials: 'include' });

// @ts-expect-error Path IDs are required.
cars.getCar();
// @ts-expect-error Path IDs are direct arguments.
cars.getCar({ id: 'CAR_ID' });
// @ts-expect-error Request bodies have no outer wrapper.
cars.createCar({ carCreate: { name: 'Company car', plate: 'LL-123AB' } });
// @ts-expect-error Required body fields remain required.
cars.createCar({ name: 'Company car' });
// @ts-expect-error Query options retain their declared types.
cars.fetchCars({ limit: '10' });
// @ts-expect-error Query options contain only query parameters.
cars.fetchCars({ id: 'CAR_ID' });
// @ts-expect-error Query filters are named rather than positional.
cars.fetchCars('Company car', true, 'PAGE_TOKEN');
// @ts-expect-error Path IDs stay outside the query object.
users.fetchUserTeamMemberships({ id: 'USER_ID', pageToken: 'PAGE_TOKEN' });
