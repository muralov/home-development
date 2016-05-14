package home.family_planner.meals.factory;

import home.family_planner.meals.model.Meal;

public class MealFactory implements IFactory {

	@Override
	public Meal create() {
		return new Meal();
	}

}
