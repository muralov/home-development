/**
 * Created by mansur on 12/8/16.
 */
'use strict';

var meals = angular.module('meals', []);

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
                .success(function (data, status) {
                    if(status == 200) {
                        updatedItem.title = entry.title;
                        updatedItem.description = entry.description;
                        updatedItem.price = entry.price;
                    }
                })
                .error(function (data, status) {
                    console.log("update could not be performed successfully.");
                });
        } else {
            $http.post("http://localhost:8080/meals", entry)
                .success(function(data) {
                    entry = data;
                })
                .error(function(data, status) {
                    console.log("update could not be performed successfully.");
                });

            mealsService.groceryItems.push(entry);
        }

    };

    return mealsService;
});