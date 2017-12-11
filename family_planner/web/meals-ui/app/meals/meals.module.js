/**
 * Created by mansur on 12/8/16.
 */
'use strict';

var meals = angular.module('meals', []);

meals.controller("GroceryAddPopup", function ($scope, $uibModal, MealPlannerService) {

    $scope.open = function (mealId) {

        MealPlannerService.getGroceriesPromise().then(
            function (result) {

                //Opening the popup window
                $uibModal.open({
                    templateUrl: "meals/linkGroceries.html",
                    controller: function ($scope, $http, MealService) {
                        $scope.groceries = result;
                        $scope.selected = [];

                        $http({method:"GET", url:"http://localhost:8080/meals/" + mealId + "/foodProducts"})
                            .then(
                                function(result){
                                    for (var i = 0; i < result.data.length; i++) {
                                        $scope.selected[result.data[i].id] = true;
                                    }
                                },
                                function (error) {
                                    console.error('error occurred: ', error);
                                }
                            );

                        $scope.save = function() {
                            var i;
                            for(var i = 0; i < $scope.selected.length; i++) {
                                if($scope.selected[i]) {
                                    MealService.addFoodProductToMeal(mealId, i);
                                } else {
                                    MealService.removeFoodProductFromMeal(mealId, i);
                                }
                            }
                        }
                    }
                });
            }
        );
    }

});

meals.service("MealService", function ($http) {
    var mealsService = {};

    mealsService.groceryItems = [];

    mealsService.getMealsPromise = function () {
        return $http({method:"GET", url:"http://localhost:8080/meals"})
            .then(
                function(result){
                    // What we return here is the data that will be accessible
                    // to us after the promise resolves
                    mealsService.groceryItems = result.data;
                    return result.data;
                },
                function (error) {
                    console.error('error occurred: ', error);
                }
            );
    }

    mealsService.getMealGroceriesPromise = function () {
        return $http({method:"GET", url:"http://localhost:8080/meals"})
            .then(
                function(result){
                    // What we return here is the data that will be accessible
                    // to us after the promise resolves
                    mealsService.groceryItems = result.data;
                    return result.data;
                },
                function (error) {
                    console.error('error occurred: ', error);
                }
            );
    }

    mealsService.findById = function(id) {
        for(var item in mealsService.groceryItems) {
            if (mealsService.groceryItems[item].id === id) {
                console.log(mealsService.groceryItems[item]);
                return mealsService.groceryItems[item];
            }
        }
    }

    mealsService.getNewId = function () {

        if(mealsService.newId) {
            mealsService.newId++;
            return mealsService.newId;
        } else {
            var maxId = _.max(mealsService.groceryItems, function (entry) {
                return entry.id;
            });
            mealsService.newId = maxId.id + 1;
            return mealsService.newId;
        }

    };

    mealsService.removeItem = function (entry) {
        $http.delete("http://localhost:8080/meals/"+ entry.id)
            .then(function(response) {
                    if(response.status) {
                        var index = mealsService.groceryItems.indexOf(entry);
                        mealsService.groceryItems.splice(index, 1);
                    }
                },
                function (error) {
                    console.error('deletion could not be performed successfully: ', error);
                }
            );
    };

    mealsService.save = function(entry) {
        var updatedItem = mealsService.findById(entry.id);
        if(updatedItem) {

            $http.post("http://localhost:8080/meals/" + entry.id, entry)
                .then(function (response) {
                    if(response.status == 200) {
                        updatedItem.title = entry.title;
                        updatedItem.description = entry.description;
                        updatedItem.price = entry.price;
                    }
                },
                function (error) {
                    console.log("update could not be performed successfully: " + error);
                });
        } else {
            $http.post("http://localhost:8080/meals", entry)
                .then(function(response) {
                        entry = response.data;
                        mealsService.groceryItems.push(entry);
                    },
                    function(error) {
                        console.log("update could not be performed successfully: " + error);
                    }
                );
        }
    };

    mealsService.addFoodProductToMeal = function(mealId, foodProductId) {
        $http({method: "PUT", url: "http://localhost:8080/meals/" + mealId + "/foodProducts/" + foodProductId})
            .then(function (data, status) {
                    if(status == 200) {
                        console.info('Food product have been added to the meal successfully.', data);
                    }
                },
                function (error) {
                    console.error('deletion could not be performed successfully: ', error);
                }
            );
    };

    mealsService.removeFoodProductFromMeal = function(mealId, foodProductId) {
        $http({method: "DELETE", url: "http://localhost:8080/meals/" + mealId + "/foodProducts/" + foodProductId})
            .then(function (data, status) {
                    if(status == 200) {
                        console.info('Food product have been deleted from the meal successfully.');
                    }
                },
                function (error) {
                    console.error('deletion could not be performed successfully: ', error);
                }
            );
    };

    return mealsService;
});