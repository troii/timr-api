# timr-api@1.0.0

A TypeScript SDK client for the api.timr.com API.

## Usage

First, install the SDK from npm.

```bash
npm install timr-api --save
```

Next, try it out.


```ts
import {
  Configuration,
  CarApi,
} from 'timr-api';
import type { CreateCarRequest } from 'timr-api';

async function example() {
  console.log("🚀 Testing timr-api SDK...");
  const config = new Configuration({ 
    // To configure OAuth2 access token for authorization: OAuth2 application
    accessToken: "YOUR ACCESS TOKEN",
    // To configure OAuth2 access token for authorization: OAuth2 accessCode
    accessToken: "YOUR ACCESS TOKEN",
  });
  const api = new CarApi(config);

  const body = {
    // CarCreate | Car entity
    carCreate: ...,
  } satisfies CreateCarRequest;

  try {
    const data = await api.createCar(body);
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```


## Documentation

### API Endpoints

All URIs are relative to *https://api.timr.com/v1*

| Class | Method | HTTP request | Description
| ----- | ------ | ------------ | -------------
*CarApi* | [**createCar**](docs/CarApi.md#createcar) | **POST** /cars | Create a Car
*CarApi* | [**fetchCars**](docs/CarApi.md#fetchcars) | **GET** /cars | List Cars
*CarApi* | [**getCar**](docs/CarApi.md#getcar) | **GET** /cars/{id} | Get a Car
*CarApi* | [**updateCar**](docs/CarApi.md#updatecar) | **PATCH** /cars/{id} | Update a Car
*DriveLogApi* | [**createDriveLog**](docs/DriveLogApi.md#createdrivelog) | **POST** /drive-logs | Create a Drive Log
*DriveLogApi* | [**deleteDriveLog**](docs/DriveLogApi.md#deletedrivelog) | **DELETE** /drive-logs/{id} | Delete a Drive Log
*DriveLogApi* | [**fetchDeletedDriveLogs**](docs/DriveLogApi.md#fetchdeleteddrivelogs) | **GET** /drive-logs:deleted | List deleted Drive Logs
*DriveLogApi* | [**fetchDriveLogs**](docs/DriveLogApi.md#fetchdrivelogs) | **GET** /drive-logs | List Drive Logs
*DriveLogApi* | [**getDriveLog**](docs/DriveLogApi.md#getdrivelog) | **GET** /drive-logs/{id} | Get a Drive Log
*DriveLogApi* | [**updateDriveLog**](docs/DriveLogApi.md#updatedrivelog) | **PATCH** /drive-logs/{id} | Update a Drive Log
*DriveLogCategoryApi* | [**fetchDriveLogCategories**](docs/DriveLogCategoryApi.md#fetchdrivelogcategories) | **GET** /drive-log-categories | List Drive Log Categories
*DriveLogCategoryApi* | [**getDriveLogCategory**](docs/DriveLogCategoryApi.md#getdrivelogcategory) | **GET** /drive-log-categories/{id} | Get a Drive Log Category
*HolidayCalendarApi* | [**fetchHolidayCalendars**](docs/HolidayCalendarApi.md#fetchholidaycalendars) | **GET** /holiday-calendars | List Holiday Calendars
*HolidayCalendarApi* | [**fetchHolidays**](docs/HolidayCalendarApi.md#fetchholidays) | **GET** /holiday-calendars/{id}/holidays | List Holidays
*HolidayCalendarApi* | [**getHolidayCalendar**](docs/HolidayCalendarApi.md#getholidaycalendar) | **GET** /holiday-calendars/{id} | Get a Holiday Calendar
*ProjectTimeApi* | [**createProjectTime**](docs/ProjectTimeApi.md#createprojecttime) | **POST** /project-times | Create a Project Time
*ProjectTimeApi* | [**deleteProjectTime**](docs/ProjectTimeApi.md#deleteprojecttime) | **DELETE** /project-times/{id} | Delete a Project Time
*ProjectTimeApi* | [**fetchDeletedProjectTimes**](docs/ProjectTimeApi.md#fetchdeletedprojecttimes) | **GET** /project-times:deleted | List deleted Project Times
*ProjectTimeApi* | [**fetchProjectTimes**](docs/ProjectTimeApi.md#fetchprojecttimes) | **GET** /project-times | List Project Times
*ProjectTimeApi* | [**getProjectTime**](docs/ProjectTimeApi.md#getprojecttime) | **GET** /project-times/{id} | Get a Project Time
*ProjectTimeApi* | [**updateProjectTime**](docs/ProjectTimeApi.md#updateprojecttime) | **PATCH** /project-times/{id} | Update a Project Time
*TaskApi* | [**createTask**](docs/TaskApi.md#createtask) | **POST** /tasks | Create a Task
*TaskApi* | [**fetchTasks**](docs/TaskApi.md#fetchtasks) | **GET** /tasks | List Tasks
*TaskApi* | [**fetchUserTasks**](docs/TaskApi.md#fetchusertasks) | **GET** /users/{id}/tasks | List a User\&#39;s Tasks
*TaskApi* | [**getTask**](docs/TaskApi.md#gettask) | **GET** /tasks/{id} | Get a Task
*TaskApi* | [**updateTask**](docs/TaskApi.md#updatetask) | **PATCH** /tasks/{id} | Update a Task
*TaskToLeaderAssignmentApi* | [**createTaskToLeaderAssignment**](docs/TaskToLeaderAssignmentApi.md#createtasktoleaderassignment) | **PUT** /tasks/{task_id}/leaders/{user_id} | Create a Task to Leader Assignment
*TaskToLeaderAssignmentApi* | [**deleteTaskToLeaderAssignment**](docs/TaskToLeaderAssignmentApi.md#deletetasktoleaderassignment) | **DELETE** /tasks/{task_id}/leaders/{user_id} | Delete a Task to Leader Assignment
*TaskToLeaderAssignmentApi* | [**fetchTaskToLeaderAssignments**](docs/TaskToLeaderAssignmentApi.md#fetchtasktoleaderassignments) | **GET** /tasks/{task_id}/leaders | List Task to Leader Assignments
*TaskToLeaderAssignmentApi* | [**getTaskToLeaderAssignment**](docs/TaskToLeaderAssignmentApi.md#gettasktoleaderassignment) | **GET** /tasks/{task_id}/leaders/{user_id} | Get a Task to Leader Assignment
*TaskToTeamAssignmentApi* | [**createTaskToTeamAssignment**](docs/TaskToTeamAssignmentApi.md#createtasktoteamassignment) | **PUT** /tasks/{task_id}/teams/{team_id} | Create a Task to Team Assignment
*TaskToTeamAssignmentApi* | [**deleteTaskToTeamAssignment**](docs/TaskToTeamAssignmentApi.md#deletetasktoteamassignment) | **DELETE** /tasks/{task_id}/teams/{team_id} | Delete a Task to Team Assignment
*TaskToTeamAssignmentApi* | [**fetchTaskToTeamAssignments**](docs/TaskToTeamAssignmentApi.md#fetchtasktoteamassignments) | **GET** /tasks/{task_id}/teams | List Task to Team Assignments
*TaskToTeamAssignmentApi* | [**getTaskToTeamAssignment**](docs/TaskToTeamAssignmentApi.md#gettasktoteamassignment) | **GET** /tasks/{task_id}/teams/{team_id} | Get a Task to Team Assignment
*TaskToUserAssignmentApi* | [**deleteTaskToUserAssignment**](docs/TaskToUserAssignmentApi.md#deletetasktouserassignment) | **DELETE** /tasks/{task_id}/users/{user_id} | Delete a Task to User Assignment
*TaskToUserAssignmentApi* | [**fetchTaskToUserAssignments**](docs/TaskToUserAssignmentApi.md#fetchtasktouserassignments) | **GET** /tasks/{task_id}/users | List Task to User Assignments
*TaskToUserAssignmentApi* | [**getTaskToUserAssignment**](docs/TaskToUserAssignmentApi.md#gettasktouserassignment) | **GET** /tasks/{task_id}/users/{user_id} | Get a Task to User Assignment
*TaskToUserAssignmentApi* | [**upsertTaskToUserAssignment**](docs/TaskToUserAssignmentApi.md#upserttasktouserassignment) | **PUT** /tasks/{task_id}/users/{user_id} | Create or update a Task to User Assignment
*TeamApi* | [**addTeamLeader**](docs/TeamApi.md#addteamleader) | **PUT** /teams/{team_id}/leaders/{user_id} | Add a Team Leader
*TeamApi* | [**addTeamMember**](docs/TeamApi.md#addteammember) | **PUT** /teams/{team_id}/members/{user_id} | Add a Team Member
*TeamApi* | [**createTeam**](docs/TeamApi.md#createteam) | **POST** /teams | Create a Team
*TeamApi* | [**deleteTeam**](docs/TeamApi.md#deleteteam) | **DELETE** /teams/{id} | Delete a Team
*TeamApi* | [**fetchTeamLeaders**](docs/TeamApi.md#fetchteamleaders) | **GET** /teams/{id}/leaders | List Team Leaders
*TeamApi* | [**fetchTeamMembers**](docs/TeamApi.md#fetchteammembers) | **GET** /teams/{id}/members | List Team Members
*TeamApi* | [**fetchTeams**](docs/TeamApi.md#fetchteams) | **GET** /teams | List Teams
*TeamApi* | [**getTeam**](docs/TeamApi.md#getteam) | **GET** /teams/{id} | Get a Team
*TeamApi* | [**getTeamLeader**](docs/TeamApi.md#getteamleader) | **GET** /teams/{team_id}/leaders/{user_id} | Get a Team Leader
*TeamApi* | [**getTeamMember**](docs/TeamApi.md#getteammember) | **GET** /teams/{team_id}/members/{user_id} | Get a Team Member
*TeamApi* | [**removeTeamLeader**](docs/TeamApi.md#removeteamleader) | **DELETE** /teams/{team_id}/leaders/{user_id} | Remove a Team Leader
*TeamApi* | [**removeTeamMember**](docs/TeamApi.md#removeteammember) | **DELETE** /teams/{team_id}/members/{user_id} | Remove a Team Member
*TeamApi* | [**updateTeam**](docs/TeamApi.md#updateteam) | **PATCH** /teams/{id} | Update a Team
*TimeAccountApi* | [**getUserAccounts**](docs/TimeAccountApi.md#getuseraccounts) | **GET** /users/{id}/accounts/{date} | Get a User\&#39;s accounts
*TimeAccountApi* | [**getUserWorkingTimeAccounts**](docs/TimeAccountApi.md#getuserworkingtimeaccounts) | **GET** /users/{id}/working-time-accounts/{date} | Get a User\&#39;s working time accounts
*TrackApi* | [**createTrack**](docs/TrackApi.md#createtrack) | **POST** /drive-logs/{id}/track | Create a Drive Log\&#39;s Track
*TrackApi* | [**deleteTrack**](docs/TrackApi.md#deletetrack) | **DELETE** /drive-logs/{id}/track | Delete a Drive Log\&#39;s Track
*TrackApi* | [**getTrack**](docs/TrackApi.md#gettrack) | **GET** /drive-logs/{id}/track | Get a Drive Log\&#39;s Track
*TrackApi* | [**updateTrack**](docs/TrackApi.md#updatetrack) | **PUT** /drive-logs/{id}/track | Replace a Drive Log\&#39;s Track
*UserApi* | [**createUser**](docs/UserApi.md#createuser) | **POST** /users | Create a User
*UserApi* | [**fetchUserTeamLeaderships**](docs/UserApi.md#fetchuserteamleaderships) | **GET** /users/{id}/team-leaderships | List a User\&#39;s Team leaderships
*UserApi* | [**fetchUserTeamMemberships**](docs/UserApi.md#fetchuserteammemberships) | **GET** /users/{id}/team-memberships | List a User\&#39;s Team memberships
*UserApi* | [**fetchUsers**](docs/UserApi.md#fetchusers) | **GET** /users | List Users
*UserApi* | [**getUser**](docs/UserApi.md#getuser) | **GET** /users/{id} | Get a User
*UserApi* | [**getUserWorkScheduleModel**](docs/UserApi.md#getuserworkschedulemodel) | **GET** /users/{id}/work-schedule-model | Get a User\&#39;s Work Schedule Model
*UserApi* | [**updateUser**](docs/UserApi.md#updateuser) | **PATCH** /users/{id} | Update a User
*WorkScheduleModelApi* | [**deleteWorkScheduleModel**](docs/WorkScheduleModelApi.md#deleteworkschedulemodel) | **DELETE** /work-schedule-models/{id} | Delete a Work Schedule Model
*WorkScheduleModelApi* | [**fetchWorkScheduleModels**](docs/WorkScheduleModelApi.md#fetchworkschedulemodels) | **GET** /work-schedule-models | List Work Schedule Models
*WorkScheduleModelApi* | [**getWorkScheduleModel**](docs/WorkScheduleModelApi.md#getworkschedulemodel) | **GET** /work-schedule-models/{id} | Get a Work Schedule Model
*WorkingTimeApi* | [**createWorkingTime**](docs/WorkingTimeApi.md#createworkingtime) | **POST** /working-times | Create a Working Time
*WorkingTimeApi* | [**deleteWorkingTime**](docs/WorkingTimeApi.md#deleteworkingtime) | **DELETE** /working-times/{id} | Delete a Working Time
*WorkingTimeApi* | [**fetchDeletedWorkingTimes**](docs/WorkingTimeApi.md#fetchdeletedworkingtimes) | **GET** /working-times:deleted | List deleted Working Times
*WorkingTimeApi* | [**fetchWorkingTimes**](docs/WorkingTimeApi.md#fetchworkingtimes) | **GET** /working-times | List Working Times
*WorkingTimeApi* | [**getWorkingTime**](docs/WorkingTimeApi.md#getworkingtime) | **GET** /working-times/{id} | Get a Working Time
*WorkingTimeApi* | [**updateWorkingTime**](docs/WorkingTimeApi.md#updateworkingtime) | **PATCH** /working-times/{id} | Update a Working Time
*WorkingTimeDateSpanApi* | [**createWorkingTimeDateSpan**](docs/WorkingTimeDateSpanApi.md#createworkingtimedatespan) | **POST** /working-time-date-spans | Create a Working Time Date Span
*WorkingTimeDateSpanApi* | [**deleteWorkingTimeDateSpan**](docs/WorkingTimeDateSpanApi.md#deleteworkingtimedatespan) | **DELETE** /working-time-date-spans/{id} | Delete a Working Time Date Span
*WorkingTimeDateSpanApi* | [**fetchDeletedWorkingTimeDateSpans**](docs/WorkingTimeDateSpanApi.md#fetchdeletedworkingtimedatespans) | **GET** /working-time-date-spans:deleted | List deleted Working Time Date Spans
*WorkingTimeDateSpanApi* | [**fetchWorkingTimeDateSpans**](docs/WorkingTimeDateSpanApi.md#fetchworkingtimedatespans) | **GET** /working-time-date-spans | List Working Time Date Spans
*WorkingTimeDateSpanApi* | [**getWorkingTimeDateSpan**](docs/WorkingTimeDateSpanApi.md#getworkingtimedatespan) | **GET** /working-time-date-spans/{id} | Get a Working Time Date Span
*WorkingTimeDateSpanApi* | [**updateWorkingTimeDateSpan**](docs/WorkingTimeDateSpanApi.md#updateworkingtimedatespan) | **PATCH** /working-time-date-spans/{id} | Update a Working Time Date Span
*WorkingTimeTypeApi* | [**deleteWorkingTimeType**](docs/WorkingTimeTypeApi.md#deleteworkingtimetype) | **DELETE** /working-time-types/{id} | Delete a Working Time Type
*WorkingTimeTypeApi* | [**fetchWorkingTimeTypes**](docs/WorkingTimeTypeApi.md#fetchworkingtimetypes) | **GET** /working-time-types | List Working Time Types
*WorkingTimeTypeApi* | [**getWorkingTimeType**](docs/WorkingTimeTypeApi.md#getworkingtimetype) | **GET** /working-time-types/{id} | Get a Working Time Type


### Models

- [Accounts](docs/Accounts.md)
- [BreakTime](docs/BreakTime.md)
- [BreakTimeAutomatic](docs/BreakTimeAutomatic.md)
- [BreakTimeBase](docs/BreakTimeBase.md)
- [BreakTimeManual](docs/BreakTimeManual.md)
- [BreakTimeOngoing](docs/BreakTimeOngoing.md)
- [BreakTimeType](docs/BreakTimeType.md)
- [BreakTimeUpdate](docs/BreakTimeUpdate.md)
- [BudgetPlanningType](docs/BudgetPlanningType.md)
- [BudgetPlanningTypeRequest](docs/BudgetPlanningTypeRequest.md)
- [Car](docs/Car.md)
- [CarCreate](docs/CarCreate.md)
- [CarPartial](docs/CarPartial.md)
- [CarUpdate](docs/CarUpdate.md)
- [CarsPage](docs/CarsPage.md)
- [CarsSortColumn](docs/CarsSortColumn.md)
- [DailyWorkSchedule](docs/DailyWorkSchedule.md)
- [DeletedEntryPage](docs/DeletedEntryPage.md)
- [DeletedEntryPartial](docs/DeletedEntryPartial.md)
- [DeletedEntrySortColumn](docs/DeletedEntrySortColumn.md)
- [DeletedEntryWithMetadata](docs/DeletedEntryWithMetadata.md)
- [DeletedEntryWithMetadataPage](docs/DeletedEntryWithMetadataPage.md)
- [DriveLog](docs/DriveLog.md)
- [DriveLogCategoriesPage](docs/DriveLogCategoriesPage.md)
- [DriveLogCategoriesSortColumn](docs/DriveLogCategoriesSortColumn.md)
- [DriveLogCategory](docs/DriveLogCategory.md)
- [DriveLogCategoryPartial](docs/DriveLogCategoryPartial.md)
- [DriveLogCreate](docs/DriveLogCreate.md)
- [DriveLogStatus](docs/DriveLogStatus.md)
- [DriveLogUpdate](docs/DriveLogUpdate.md)
- [DriveLogUpsert](docs/DriveLogUpsert.md)
- [DriveLogsPage](docs/DriveLogsPage.md)
- [DriveLogsSortColumn](docs/DriveLogsSortColumn.md)
- [Duration](docs/Duration.md)
- [DurationType](docs/DurationType.md)
- [DurationUnit](docs/DurationUnit.md)
- [ErrorEntry](docs/ErrorEntry.md)
- [FlexTimeIndicator](docs/FlexTimeIndicator.md)
- [Holiday](docs/Holiday.md)
- [HolidayCalendarPartial](docs/HolidayCalendarPartial.md)
- [HolidayCalendarsPage](docs/HolidayCalendarsPage.md)
- [HolidayCalendarsSortColumn](docs/HolidayCalendarsSortColumn.md)
- [HolidaysPage](docs/HolidaysPage.md)
- [HolidaysSortColumn](docs/HolidaysSortColumn.md)
- [Location](docs/Location.md)
- [LocationCreate](docs/LocationCreate.md)
- [LocationUpdate](docs/LocationUpdate.md)
- [ModelError](docs/ModelError.md)
- [NormalWorkingTimes](docs/NormalWorkingTimes.md)
- [OvertimeSurchargeAccount](docs/OvertimeSurchargeAccount.md)
- [OvertimeSurchargeAccounts](docs/OvertimeSurchargeAccounts.md)
- [OvertimeSurchargeRule](docs/OvertimeSurchargeRule.md)
- [PagingInformation](docs/PagingInformation.md)
- [Platform](docs/Platform.md)
- [ProblemDetail](docs/ProblemDetail.md)
- [ProjectTime](docs/ProjectTime.md)
- [ProjectTimeCreate](docs/ProjectTimeCreate.md)
- [ProjectTimeStatus](docs/ProjectTimeStatus.md)
- [ProjectTimeUpdate](docs/ProjectTimeUpdate.md)
- [ProjectTimeUpsert](docs/ProjectTimeUpsert.md)
- [ProjectTimesPage](docs/ProjectTimesPage.md)
- [ProjectTimesSortColumn](docs/ProjectTimesSortColumn.md)
- [RecordingLockType](docs/RecordingLockType.md)
- [RecordingModeUser](docs/RecordingModeUser.md)
- [SortDirection](docs/SortDirection.md)
- [Task](docs/Task.md)
- [TaskBase](docs/TaskBase.md)
- [TaskCreate](docs/TaskCreate.md)
- [TaskLocation](docs/TaskLocation.md)
- [TaskPartial](docs/TaskPartial.md)
- [TaskReduced](docs/TaskReduced.md)
- [TaskToLeaderAssignment](docs/TaskToLeaderAssignment.md)
- [TaskToLeaderAssignmentsPage](docs/TaskToLeaderAssignmentsPage.md)
- [TaskToLeaderAssignmentsSortColumn](docs/TaskToLeaderAssignmentsSortColumn.md)
- [TaskToTeamAssignment](docs/TaskToTeamAssignment.md)
- [TaskToTeamAssignmentsPage](docs/TaskToTeamAssignmentsPage.md)
- [TaskToTeamAssignmentsSortColumn](docs/TaskToTeamAssignmentsSortColumn.md)
- [TaskToUserAssignment](docs/TaskToUserAssignment.md)
- [TaskToUserAssignmentUpsert](docs/TaskToUserAssignmentUpsert.md)
- [TaskToUserAssignmentsPage](docs/TaskToUserAssignmentsPage.md)
- [TaskToUserAssignmentsSortColumn](docs/TaskToUserAssignmentsSortColumn.md)
- [TaskUpdate](docs/TaskUpdate.md)
- [TasksPage](docs/TasksPage.md)
- [TasksReducedPage](docs/TasksReducedPage.md)
- [TasksSortColumn](docs/TasksSortColumn.md)
- [Team](docs/Team.md)
- [TeamCreate](docs/TeamCreate.md)
- [TeamPartial](docs/TeamPartial.md)
- [TeamUpdate](docs/TeamUpdate.md)
- [TeamsPage](docs/TeamsPage.md)
- [TeamsPartialPage](docs/TeamsPartialPage.md)
- [TeamsSortColumn](docs/TeamsSortColumn.md)
- [TimeAccount](docs/TimeAccount.md)
- [User](docs/User.md)
- [UserCreate](docs/UserCreate.md)
- [UserPartial](docs/UserPartial.md)
- [UserUpdate](docs/UserUpdate.md)
- [UsersPage](docs/UsersPage.md)
- [UsersPartialPage](docs/UsersPartialPage.md)
- [UsersSortColumn](docs/UsersSortColumn.md)
- [VacationAccount](docs/VacationAccount.md)
- [VacationAccountBase](docs/VacationAccountBase.md)
- [VacationAccountDays](docs/VacationAccountDays.md)
- [VacationAccountMinutes](docs/VacationAccountMinutes.md)
- [VacationUnit](docs/VacationUnit.md)
- [VenuePartial](docs/VenuePartial.md)
- [Waypoint](docs/Waypoint.md)
- [WorkScheduleModel](docs/WorkScheduleModel.md)
- [WorkScheduleModelPartial](docs/WorkScheduleModelPartial.md)
- [WorkScheduleModelSortColumn](docs/WorkScheduleModelSortColumn.md)
- [WorkScheduleModelType](docs/WorkScheduleModelType.md)
- [WorkScheduleModelWeek](docs/WorkScheduleModelWeek.md)
- [WorkScheduleModelsPage](docs/WorkScheduleModelsPage.md)
- [WorkingTime](docs/WorkingTime.md)
- [WorkingTimeCreate](docs/WorkingTimeCreate.md)
- [WorkingTimeDateSpan](docs/WorkingTimeDateSpan.md)
- [WorkingTimeDateSpanCreate](docs/WorkingTimeDateSpanCreate.md)
- [WorkingTimeDateSpanPage](docs/WorkingTimeDateSpanPage.md)
- [WorkingTimeDateSpanPartial](docs/WorkingTimeDateSpanPartial.md)
- [WorkingTimeDateSpanUpdate](docs/WorkingTimeDateSpanUpdate.md)
- [WorkingTimeDateSpansSortColumn](docs/WorkingTimeDateSpansSortColumn.md)
- [WorkingTimeRules](docs/WorkingTimeRules.md)
- [WorkingTimeStatus](docs/WorkingTimeStatus.md)
- [WorkingTimeType](docs/WorkingTimeType.md)
- [WorkingTimeTypeCategory](docs/WorkingTimeTypeCategory.md)
- [WorkingTimeTypePartial](docs/WorkingTimeTypePartial.md)
- [WorkingTimeTypeSubCategory](docs/WorkingTimeTypeSubCategory.md)
- [WorkingTimeTypesPage](docs/WorkingTimeTypesPage.md)
- [WorkingTimeTypesSortColumn](docs/WorkingTimeTypesSortColumn.md)
- [WorkingTimeUpdate](docs/WorkingTimeUpdate.md)
- [WorkingTimeUpsert](docs/WorkingTimeUpsert.md)
- [WorkingTimesPage](docs/WorkingTimesPage.md)
- [WorkingTimesSortColumn](docs/WorkingTimesSortColumn.md)

### Authorization


Authentication schemes defined for the API:
<a id="OAuth2-application"></a>
#### OAuth2 application


- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: 
  - `openid`: Authenticate the OAuth client.
  - `timrclient`: Access timr data in the client context.
<a id="OAuth2-accessCode"></a>
#### OAuth2 accessCode


- **Type**: OAuth
- **Flow**: accessCode
- **Authorization URL**: https://system.timr.com/id/oauth2/authorize
- **Scopes**: 
  - `openid`: Authenticate the timr user.
  - `offline_access`: Request a refresh token for continued access.

## About

This TypeScript SDK client supports the [Fetch API](https://fetch.spec.whatwg.org/)
and is automatically generated by the
[OpenAPI Generator](https://openapi-generator.tech) project:

- API version: `1.0.0`
- Package version: `1.0.0`
- Generator version: `7.22.0`
- Build package: `org.openapitools.codegen.languages.TypeScriptFetchClientCodegen`

The generated npm module supports the following:

- Environments
  * Node.js
  * Webpack
  * Browserify
- Language levels
  * ES5 - you must have a Promises/A+ library installed
  * ES6
- Module systems
  * CommonJS
  * ES6 module system

For more information, please visit [https://www.timr.com](https://www.timr.com)

## Development

### Building

To build the TypeScript source code, you need to have Node.js and npm installed.
After cloning the repository, navigate to the project directory and run:

```bash
npm install
npm run build
```

### Publishing

Once you've built the package, you can publish it to npm:

```bash
npm publish
```

## License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0.html)
