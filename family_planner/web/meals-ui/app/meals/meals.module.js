/**
 * Created by mansur on 12/8/16.
 */
'use strict';

var meals = angular.module('meals', []);

meals.service("GroceryService", function ($http) {
    var groceryService = {};

    groceryService.groceryItems = [];

    groceryService.getFoodProducts = function () {
        $http.get('http://localhost:8080/foodProducts').then(function(response) {
                groceryService.groceryItems = response.data;
            },
            function (error) {
                console.error('error occurred: ', error);
            });
    }

    groceryService.getFoodProductsPromise = function () {
        return $http({method:"GET", url:"http://localhost:8080/foodProducts"})
            .then(
                function(result){
                    // What we return here is the data that will be accessible
                    // to us after the promise resolves
                    groceryService.groceryItems = result.data;
                    return result.data;
                },
                function (error) {
                    console.error('error occurred: ', error);
                }
            );
    }

    groceryService.findById = function(id) {
        for(var item in groceryService.groceryItems) {
            if (groceryService.groceryItems[item].id === id) {
                console.log(groceryService.groceryItems[item]);
                return groceryService.groceryItems[item];
            }
        }
    }

    groceryService.getNewId = function () {

        if(groceryService.newId) {
            groceryService.newId++;
            return groceryService.newId;
        } else {
            var maxId = _.max(groceryService.groceryItems, function (entry) {
                return entry.id;
            });
            groceryService.newId = maxId.id + 1;
            return groceryService.newId;
        }

    };

    groceryService.removeItem = function (entry) {
        $http.delete("http://localhost:8080/foodProducts/"+ entry.id)
            .then(function(response) {
                    if(response.status) {
                        var index = groceryService.groceryItems.indexOf(entry);
                        groceryService.groceryItems.splice(index, 1);
                    }
                },
                function (error) {
                    console.error('deletion could not be performed successfully: ', error);
                }
            );
    };

    groceryService.save = function(entry) {

        var updatedItem = groceryService.findById(entry.id);
        if(updatedItem) {

            $http.post("http://localhost:8080/foodProducts/" + entry.id, entry)
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
            $http.post("http://localhost:8080/foodProducts", entry)
                .success(function(data) {
                    entry = data;
                })
                .error(function(data, status) {
                    console.log("update could not be performed successfully.");
                });

            groceryService.groceryItems.push(entry);
        }

    };

    return groceryService;
});