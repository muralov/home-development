/**
 * Created by mansur on 12/8/16.
 */
'use strict';

// Define the `meal-ui` module
var mealPlanner = angular.module('meal-planner', [
    // ...which depends on the `meals` module
    'ngRoute',
    'meals',
    'groceries',
    'ui.bootstrap'
]);

mealPlanner.service("MealPlannerService", function ($http) {
    var mealPlannerService = {};

    mealPlannerService.groceries = [];

    mealPlannerService.getGroceriesPromise = function () {
        return $http({method:"GET", url:"http://localhost:8080/foodProducts"})
            .then(
                function(result){
                    // What we return here is the data that will be accessible
                    // to us after the promise resolves
                    mealPlannerService.groceries = result.data;
                    return result.data;
                },
                function (error) {
                    console.error('error occurred: ', error);
                }
            );
    }

    return mealPlannerService;
});
