/**
 * Created by MUR on 15.06.2016.
 */

var groceryList = angular.module("groceryListCtrl", []);

groceryList.controller("GroceryListCtrl", function ($scope, $routeParams, $location, GroceryService) {

    if(!$routeParams.id) {
        $scope.groceryItem = {id: 0, completed: false, itemName: "", date: new Date()};
    } else {
        $scope.groceryItem = _.clone(GroceryService.findById(parseInt($routeParams.id)));
    }

    $scope.save = function () {
        GroceryService.save($scope.groceryItem);
        $location.path("/");
    }

    console.log($scope.groceryItems);
});