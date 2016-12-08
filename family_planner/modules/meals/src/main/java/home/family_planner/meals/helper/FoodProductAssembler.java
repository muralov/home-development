package home.family_planner.meals.helper;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import home.family_planner.meals.controller.FoodProductController;
import home.family_planner.meals.model.FoodProduct;
import home.family_planner.meals.resource.FoodProductResource;

public class FoodProductAssembler extends ResourceAssemblerSupport<FoodProduct, FoodProductResource>{

	public FoodProductAssembler() {
		super(FoodProductController.class, FoodProductResource.class);
	}

	@Override
	public FoodProductResource toResource(FoodProduct entity) {
		FoodProductResource resource = createResourceWithId(entity.getId(), entity);
		resource.setFoodProductId(entity.getId());
		resource.setTitle(entity.getTitle());
		resource.setDescription(entity.getDescription());
		resource.setPrice(entity.getPrice());
		return resource;
	}

}
