package home.family_planner.meals.helper;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import home.family_planner.meals.controller.ReceiptController;
import home.family_planner.meals.model.Receipt;
import home.family_planner.meals.resource.ReceiptResource;

public class ReceiptResourceAssembler extends ResourceAssemblerSupport<Receipt, ReceiptResource> {

	public ReceiptResourceAssembler() {
		super(ReceiptController.class, ReceiptResource.class);
	}

	@Override
	public ReceiptResource toResource(Receipt entity) {
		ReceiptResource resource = createResourceWithId(entity.getId(), entity);
		resource.setDescription(entity.getDescription());
		return resource;
	}

}
