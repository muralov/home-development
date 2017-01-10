/**
 * Created by mansur on 12/9/16.
 */
'use strict';
var mealPlanner = angular.module('meal-planner');
mealPlanner.config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');

        $routeProvider.
        when('/', {
            template: '<planner-table></planner-table>'
        }).
        when('/groceries', {
            template: '<grocery-list></grocery-list>'
        }).
        when('/groceries/addItem', {
            template: '<add-edit-item></add-edit-item>'
        }).
        when('/groceries/addItem/edit/:id/', {
            template: '<add-edit-item></add-edit-item>'
        }).
        when('/planner', {
            template: '<meal-list></meal-list>'
        }).
        when('/planner/addItem', {
            template: '<meal-add-edit-item></meal-add-edit-item>'
        }).
        when('/planner/addItem/edit/:id/', {
            template: '<meal-add-edit-item></meal-add-edit-item>'
        }).
        otherwise({
             redirectTo: '/'
        });
    }
]);

// mealPlanner.run([
//     '$rootScope',
//     function($rootScope) {
//         // see what's going on when the route tries to change
//         $rootScope.$on('$routeChangeStart', function(event, next, current) {
//             // next is an object that is the route that we are starting to go to
//             // current is an object that is the route where we are currently
//             var currentPath = current.originalPath;
//             var nextPath = next.originalPath;
//
//             console.log('Starting to leave %s to go to %s', currentPath, nextPath);
//         });
//     }
// ]);
