/**
 * Created by mansur on 12/10/16.
 */
'use strict';

var meals = angular.module('groceries');

meals.component('addEditItem', {
    templateUrl: 'groceries/addEditItem.html',
    controller: function EditItemCtrl($routeParams, $location, GroceryService) {
        if(!$routeParams.id) {
            this.groceryItem = {id: 0};
        } else {
            this.groceryItem = angular.copy(GroceryService.findById(parseInt($routeParams.id)));
        }

        this.save = function () {
            GroceryService.save(this.groceryItem);
            $location.path("/");
        }
    }
});