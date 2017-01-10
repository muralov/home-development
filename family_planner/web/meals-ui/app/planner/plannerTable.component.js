/**
 * Created by mansur on 1/20/17.
 */
'use strict';

angular.module("planner").
component("plannerTable", {
    templateUrl: "planner/plannerTable.html",
    controller: function ($http, PlannerService) {
        var self = this;
        PlannerService.getPlan("plans/17187")
            .then(
                function(result){
                    self.plan = result;
                }
            );
    }
})
