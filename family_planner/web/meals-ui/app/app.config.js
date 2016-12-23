/**
 * Created by mansur on 12/9/16.
 */
'use strict';
angular.
    module('meal-planner').
    config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');

        $routeProvider.
        when('/groceries', {
            template: '<grocery-list></grocery-list>'
        }).
        when('/groceries/addItem', {
            template: '<add-edit-item></add-edit-item>'
        }).
        when('/groceries/addItem/edit/:id/', {
            template: '<add-edit-item></add-edit-item>'
        }).
        when('/meals', {
            template: '<meal-list></meal-list>'
        }).
        when('/meals/addItem', {
            template: '<add-edit-item></add-edit-item>'
        }).
        when('/meals/addItem/edit/:id/', {
            template: '<add-edit-item></add-edit-item>'
        }).
        otherwise({
             template: "index.html"
        });
    }
]);
