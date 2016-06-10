package home.family_planner.meals.resource;

import org.springframework.hateoas.ResourceSupport;

public class ReceiptResource extends ResourceSupport{

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
