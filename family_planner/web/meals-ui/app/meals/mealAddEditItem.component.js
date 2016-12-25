/**
 * Created by mansur on 12/10/16.
 */
'use strict';

var meals = angular.module('meals');

meals.component('mealAddEditItem', {
    templateUrl: 'meals/addEditItem.html',
    controller: function EditItemCtrl($routeParams, $location, MealService) {
        if(!$routeParams.id) {
            this.groceryItem = {id: 0};
        } else {
            this.groceryItem = angular.copy(MealService.findById(parseInt($routeParams.id)));
        }

        this.save = function () {
            MealService.save(this.groceryItem);
            $location.path("/meals");
        }
    }
});