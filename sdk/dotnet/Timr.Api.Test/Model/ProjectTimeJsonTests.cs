using Timr.Api.Model;
using Xunit;

namespace Timr.Api.Test.Model;

public class ProjectTimeJsonTests : IClassFixture<JsonSerializerFixture>
{
    private readonly JsonSerializerFixture _fixture;

    public ProjectTimeJsonTests(JsonSerializerFixture fixture)
    {
        _fixture = fixture;
    }

    [Fact]
    public void Deserializes_ProjectTime_With_Null_EndPlatform()
    {
        const string json = """
        {
            "id": "a131c9ef-9b3c-448a-808f-4f412f1eb344",
            "start": "2025-11-19T08:00:00+01:00",
            "end": null,
            "break_time_total_minutes": 0,
            "break_times": [],
            "changed": false,
            "user": {
                "id": "ad903edc-0a96-4ec1-ba22-f18e721978e1",
                "firstname": "Max",
                "lastname": "Muster",
                "fullname": "Max Muster",
                "email": "max@example.com",
                "employee_number": null,
                "external_id": null
            },
            "task": {
                "id": "ad903edc-0a96-4ec1-ba22-f18e721978e1",
                "name": "Task",
                "breadcrumbs": "Task",
                "external_id": null
            },
            "billable": true,
            "start_platform": "timr_api",
            "end_platform": null,
            "last_modified": "2025-11-19T08:00:00+01:00",
            "status": "running",
            "duration": null,
            "notes": null,
            "start_location": null,
            "end_location": null,
            "last_modified_by": null
        }
        """;

        var projectTime = _fixture.Deserialize<ProjectTime>(json);

        Assert.Equal(Platform.TimrApi, projectTime.StartPlatform);
        Assert.Null(projectTime.EndPlatform);
    }

    [Fact]
    public void Deserializes_ProjectTime_With_Null_StartPlatform()
    {
        // start_platform is required (always present) but nullable: getCurrentPlatform()
        // on the backend returns null for non-platform auth contexts, so the value can be null.
        const string json = """
        {
            "id": "a131c9ef-9b3c-448a-808f-4f412f1eb344",
            "start": "2025-11-19T08:00:00+01:00",
            "end": null,
            "break_time_total_minutes": 0,
            "break_times": [],
            "changed": false,
            "user": {
                "id": "ad903edc-0a96-4ec1-ba22-f18e721978e1",
                "firstname": "Max",
                "lastname": "Muster",
                "fullname": "Max Muster",
                "email": "max@example.com",
                "employee_number": null,
                "external_id": null
            },
            "task": {
                "id": "ad903edc-0a96-4ec1-ba22-f18e721978e1",
                "name": "Task",
                "breadcrumbs": "Task",
                "external_id": null
            },
            "billable": true,
            "start_platform": null,
            "end_platform": null,
            "last_modified": "2025-11-19T08:00:00+01:00",
            "status": "running",
            "duration": null,
            "notes": null,
            "start_location": null,
            "end_location": null,
            "last_modified_by": null
        }
        """;

        var projectTime = _fixture.Deserialize<ProjectTime>(json);

        Assert.Null(projectTime.StartPlatform);
        Assert.Null(projectTime.EndPlatform);
    }

    [Fact]
    public void Leaves_Optional_Property_Unset_When_Absent_From_Json()
    {
        // "metadata" is the only non-required property on ProjectTime and is
        // deliberately omitted here; an absent optional property must stay unset
        // (IsSet == false), as opposed to a present-but-null required property.
        const string json = """
        {
            "id": "a131c9ef-9b3c-448a-808f-4f412f1eb344",
            "start": "2025-11-19T08:00:00+01:00",
            "end": "2025-11-19T09:00:00+01:00",
            "break_time_total_minutes": 0,
            "break_times": [],
            "changed": false,
            "user": {
                "id": "ad903edc-0a96-4ec1-ba22-f18e721978e1",
                "firstname": "Max",
                "lastname": "Muster",
                "fullname": "Max Muster",
                "email": "max@example.com",
                "employee_number": null,
                "external_id": null
            },
            "task": {
                "id": "ad903edc-0a96-4ec1-ba22-f18e721978e1",
                "name": "Task",
                "breadcrumbs": "Task",
                "external_id": null
            },
            "billable": true,
            "start_platform": "timr_api",
            "end_platform": "timr_api",
            "last_modified": "2025-11-19T08:00:00+01:00",
            "status": "approved",
            "duration": null,
            "notes": null,
            "start_location": null,
            "end_location": null,
            "last_modified_by": null
        }
        """;

        var projectTime = _fixture.Deserialize<ProjectTime>(json);

        Assert.False(projectTime.MetadataOption.IsSet);
    }
}
