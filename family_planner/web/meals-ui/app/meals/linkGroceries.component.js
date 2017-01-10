/**
 * Created by mansur on 12/23/16.
 */
'use strict';

var meals = angular.module('meals');

meals.component('linkGroceries', {
    templateUrl: 'planner/linkGroceries.html',
    controller: function LinkGroceriesCtrl(MealPlannerService) {
        var self = this;

        MealPlannerService.getMealsPromise().then(
            function (result) {
                self.groceries = result;
            }
        );
    }
});