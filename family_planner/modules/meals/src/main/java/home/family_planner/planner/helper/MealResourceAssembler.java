package home.family_planner.planner.helper;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import home.family_planner.planner.controller.MealController;
import home.family_planner.planner.model.Meal;
import home.family_planner.planner.resource.MealResource;

public class MealResourceAssembler extends ResourceAssemblerSupport<Meal, MealResource>{
	
	public MealResourceAssembler() {
		super(MealController.class, MealResource.class);
	}

	@Override
	public MealResource toResource(Meal entity) {
		MealResource resource = createResourceWithId(entity.getId(), entity);
		resource.setMealId(entity.getId());
		resource.setTitle(entity.getTitle());
		resource.setDescription(entity.getDescription());
		return resource;
	}
}
