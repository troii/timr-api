using System;
using Timr.Api.Client;
using Timr.Api.Model;
using Xunit;

namespace Timr.Api.Test.Model;

public class TaskJsonTests : IClassFixture<JsonSerializerFixture>
{
    private readonly JsonSerializerFixture _fixture;

    public TaskJsonTests(JsonSerializerFixture fixture)
    {
        _fixture = fixture;
    }

    [Fact]
    public void Deserializes_Task_With_Custom_Converters()
    {
        const string json = """
        {
            "id": "a131c9ef-9b3c-448a-808f-4f412f1eb344",
            "name": "10010 - Wildpfad 167, Hagen",
            "breadcrumbs": "Acadoro Aufträge Süd-West/10010 - Wildpfad 167, Hagen",
            "external_id": "10010",
            "parent_task": {
                "id": "ad903edc-0a96-4ec1-ba22-f18e721978e1",
                "name": "Acadoro Aufträge Süd-West",
                "breadcrumbs": "Acadoro Aufträge Süd-West",
                "external_id": "rootSuedWest"
            },
            "description": null,
            "description_external": null,
            "bookable": false,
            "billable": true,
            "project_time_notes_required": false,
            "start_date": null,
            "end_date": "2025-11-19",
            "lock_date": null,
            "earliest_start_time": null,
            "latest_end_time": null,
            "active_from": null,
            "active_to": "2025-11-19",
            "location_inherited": true,
            "location": null,
            "location_restriction_radius_meters": null,
            "custom_field_1": "10010",
            "custom_field_2": null,
            "custom_field_3": null
        }
        """;

        var task = _fixture.Deserialize<Task>(json);

        Assert.Equal("a131c9ef-9b3c-448a-808f-4f412f1eb344", task.Id);
        Assert.Equal("10010 - Wildpfad 167, Hagen", task.Name);
        Assert.Equal("Acadoro Aufträge Süd-West/10010 - Wildpfad 167, Hagen", task.Breadcrumbs);
        Assert.Equal("10010", task.ExternalId);
        
        // Parent Task
        
        Assert.Null(task.Description);
        Assert.Null(task.DescriptionExternal);
        Assert.False(task.Bookable);
        Assert.True(task.Billable);
        Assert.False(task.ProjectTimeNotesRequired);
        Assert.Null(task.StartDate);
        Assert.Equal(new DateOnly(2025, 11, 19), task.EndDate);
        Assert.Null(task.LockDate);
        Assert.Null(task.EarliestStartTime);
        Assert.Null(task.LatestEndTime);
        Assert.Null(task.ActiveFrom);
        Assert.Equal(new DateOnly(2025, 11, 19), task.ActiveTo);
        Assert.True(task.LocationInherited);
        Assert.Null(task.Location);
        Assert.Null(task.LocationRestrictionRadiusMeters);
        Assert.Equal("10010", task.CustomField1);
        
        Assert.False(task.BudgetInheritedOption.IsSet);
        Assert.False(task.BudgetPlanningTypeOption.IsSet);
        Assert.False(task.BudgetHourlyRateOption.IsSet);
        Assert.False(task.BudgetPlannedOption.IsSet);
        Assert.False(task.BudgetIncludeNonBillableProjectTimesOption.IsSet);
        
    }
}
