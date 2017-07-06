/**
 * Created by mansur on 2/15/17.
 */
'use strict';

angular.module("planner").
component("foodList", {
    templateUrl : "planner/foodList.html",
    controller: FoodListCtrl,
    bindings: {
        plan: '<' // or key: '<' it depends on what binding you need
    }
});

function FoodListCtrl (PlannerService) {

    this.foods = [];

    for(var i = 0; i < this.plan.days.length; i++) {
        var day = this.plan.days[i];

        for(var j = 0; j < day.mealTimes.length; j++) {
            var mealTime = day.mealTimes[j];
            this.foods.push(mealTime._links.foods);
            getMealsFoods(mealTime._links.meals, this.foods, PlannerService);
        }
    }
}

function getMealsFoods(meals, foods, PlannerService) {
    for(var i = 0; i < meals.length; i++) {
        PlannerService.getMealFoods(meals[i])
            .then(
                function(result){
                    foods.push(result);
                }
            );
    }
}