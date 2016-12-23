/**
 * Created by mansur on 12/8/16.
 */
'use strict';

var meals = angular.module('groceries');

meals.component('groceryList', {
    templateUrl: 'groceries/groceryList.html',
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