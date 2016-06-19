/**
 * Created by MUR on 15.06.2016.
 */

var home = angular.module("homeCtrl", []);

app.controller("HomeCtrl", function ($scope, GroceryService) {
    $scope.groceryItems = GroceryService.groceryItems;
    $scope.appTitle = "Grocery List";

    $scope.removeItem = function(entry) {
        GroceryService.removeItem(entry);
    }

    $scope.markCompleted = function (entry) {
        GroceryService.markCompleted(entry);
    }

    $scope.$watch(function(){return GroceryService.groceryItems;}, function (groceryItems) {
        $scope.groceryItems = groceryItems;
    })
})