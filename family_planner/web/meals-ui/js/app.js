
var app = angular.module('meals-ui', ["ngRoute", "meals"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "views/groceryList.html",
            controller: "MealListCtrl"
        })
        .when("/addItem", {
            templateUrl: "views/addEditItem.html",
            controller: "EditItemCtrl"
        })
        .when("/addItem/edit/:id/", {
            templateUrl: "views/addEditItem.html",
            controller: "EditItemCtrl"
        })
        .otherwise({
            redirectTo: "/"
        })
})

app.service("GroceryService", function ($http) {
    var groceryService = {};

    groceryService.groceryItems = [];

    $http.get("http://localhost:8080/foodProducts")
        .success(function (data) {
            groceryService.groceryItems = data;
        })
        .error(function (data, status) {
            alert("Things went wrong");
        })

    groceryService.findById = function(id) {
        for(var item in groceryService.groceryItems) {
            if (groceryService.groceryItems[item].id === id) {
                console.log(groceryService.groceryItems[item])
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

    }

    groceryService.markCompleted = function (entry) {
        entry.completed = !entry.completed;
    }

    groceryService.removeItem = function (entry) {

        $http.post("data/delete_item.json", {id: entry.id})
            .success(function (data) {
                if(data.status) {
                    var index = groceryService.groceryItems.indexOf(entry);
                    groceryService.groceryItems.splice(index, 1);
                }
            })
            .error(function (data, status) {

            });

    }

    groceryService.save = function(entry) {

        var updatedItem = groceryService.findById(entry.id);
        if(updatedItem) {

            $http.post("http://localhost:8080/foodProducts/" + entry.id, entry)
                .success(function (data, status) {
                    if(status == 200) {
                        updatedItem.itemName = entry.itemName;
                        updatedItem.description = entry.description;
                        updatedItem.price = entry.price;
                    }
                })
                .error(function (data, status) {

                });

        } else {

            $http.post("http://localhost:8080/foodProducts", entry)
                .success(function(data) {
                    entry.id = data.newId;
                })
                .error(function(data, status) {

                });

            //entry.id = groceryService.getNewId();
            groceryService.groceryItems.push(entry);
        }

    }

    return groceryService;
})

app.directive("murGroceryItem", function() {
    return {
        restrict: "E",
        templateUrl: "views/groceryItem.html"
    }
})