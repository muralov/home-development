package home.family_planner.planner.helper;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import home.family_planner.planner.controller.ReceiptController;
import home.family_planner.planner.model.Receipt;
import home.family_planner.planner.resource.ReceiptResource;

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
