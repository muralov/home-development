/**
 * Created by mansur on 12/8/16.
 */
'use strict';

var meals = angular.module('meals');

meals.component('mealList', {
    templateUrl: 'planner/mealList.html',
    controller: function MealListCtrl(MealService) {
        var self = this;

        MealService.getMealsPromise().then(
            function (result) {
                self.groceryItems = result;
            }
        );

        this.removeItem = function (entry) {
            MealService.removeItem(entry);
        }

    }
});