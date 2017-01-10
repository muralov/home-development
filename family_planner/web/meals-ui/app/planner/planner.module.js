/**
 * Created by mansur on 1/6/17.
 */
'use strict';

var meals = angular.module('planner', []);

meals.service("PlannerService", function ($http) {
    return {

        getPlan: function(resPath) {
            return $http.get("http://localhost:8081/" + resPath)
                .then(
                    function(result){
                        return result.data;
                    },
                    function (error) {
                        console.error('error occurred: ', error);
                    }
                );
        },

        getFood: function(resPath) {
            return $http.get("http://localhost:8080/" + resPath)
                .then(
                    function(result){
                        return result.data;
                    },
                    function (error) {
                        console.error('error occurred: ', error);
                    }
                );
        }

    }
});
