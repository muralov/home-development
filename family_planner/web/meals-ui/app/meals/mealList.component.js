/**
 * Created by mansur on 12/8/16.
 */
'use strict';

var meals = angular.module('meals');

meals.component('mealList', {
    templateUrl: 'meals/groceryList.html',
    controller: function MealListCtrl(GroceryService) {
        var self = this;

        GroceryService.getFoodProductsPromise().then(
            function (result) {
                self.groceryItems = result;
            }
        );

        this.removeItem = function (entry) {
            GroceryService.removeItem(entry);
        }

    }
});
//
// meals.component('mealListItem', {
//     require     :  {parentComp:'^mealList'},
//     templateUrl :  'meals/groceryListItem.html'
// });