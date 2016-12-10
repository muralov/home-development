/**
 * Created by mansur on 12/9/16.
 */
'use strict';
angular.
    module('meals-ui').
    config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');

        $routeProvider.
        when('/addItem', {
            template: '<add-edit-item></add-edit-item>'
        }).
        when('/addItem/edit/:id/', {
            template: '<add-edit-item></add-edit-item>'
        }).
        otherwise({
             template: "<meal-list></meal-list>"
        });
    }
]);
