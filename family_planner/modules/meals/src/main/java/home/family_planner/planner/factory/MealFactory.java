package home.family_planner.planner.factory;

import home.family_planner.planner.model.Meal;

public class MealFactory implements IFactory {

	@Override
	public Meal create() {
		return new Meal();
	}

}
