package home.family_planner.planner.helper;

import home.family_planner.planner.controller.PlanController;
import home.family_planner.planner.model.MealPlanPK;
import home.family_planner.planner.model.Plan;
import home.family_planner.planner.resource.PlanResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class PlanResourceAssembler extends ResourceAssemblerSupport<Plan, PlanResource>{
	
	public PlanResourceAssembler() {
		super(PlanController.class, PlanResource.class);
	}

	@Override
	public PlanResource toResource(Plan entity) {
		PlanResource resource = createResourceWithId(entity.getMealPlanPK().getPlanId(), entity);
		resource.setWeekDay(entity.getWeekDay());
		return resource;
	}

	public Plan toEntity(PlanResource resource) {
		MealPlanPK planPK = new MealPlanPK((int) resource.getPlanId(), resource.getLink(PlanController.MEALS_REL).getHref());
		Plan plan = new Plan(planPK);
		plan.setWeekDay(resource.getWeekDay());
		return plan;
	}
}
