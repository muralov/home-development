/**
 * Created by mansur on 1/20/17.
 */
'use strict';

angular.module("planner").
component("plannerTable", {
    templateUrl: "planner/plannerTable.html",
    controller: function ($http, PlannerService) {
        var self = this;
        //TODO: the following hardcoded value must be removed and the plans
        //TODO: must be retrieved dynamically
        PlannerService.getPlan("plans/17173")
            .then(
                function(result){
                    self.plan = result;
                }
            );
    }
})
