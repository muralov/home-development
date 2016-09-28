/**
 * Created by muralov on 11/09/16.
 */


var meals = angular.module("meals", []);

meals.controller("MealListCtrl", function ($scope, GroceryService) {
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
});

meals.controller("EditItemCtrl", function ($scope, $routeParams, $location, GroceryService) {

    if(!$routeParams.id) {
        $scope.groceryItem = {id: 0, completed: false, itemName: ""};
    } else {
        $scope.groceryItem = _.clone(GroceryService.findById(parseInt($routeParams.id)));
    }

    $scope.save = function () {
        GroceryService.save($scope.groceryItem);
        $location.path("/");
    }

});