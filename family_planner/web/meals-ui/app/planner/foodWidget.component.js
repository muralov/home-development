/**
 * Created by mansur on 1/7/17.
 */
'use strict';

angular.module("planner").
component("foodWidget", {
    templateUrl : "planner/foodWidget.html",
    controller: FoodWidgetCtrl,
    bindings: {
        food: '=' // or key: '<' it depends on what binding you need
    }
});

function FoodWidgetCtrl() {
    var self = this;
    this.food = self.food.title;
}