/**
 * Created by mansur on 12/8/16.
 */
'use strict';

// Define the `meal-ui` module
var mealsUI = angular.module('meal-planner', [
    // ...which depends on the `meals` module
    'ngRoute',
    'meals',
    'groceries'
]);
