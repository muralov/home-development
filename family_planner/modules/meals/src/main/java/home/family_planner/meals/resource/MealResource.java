package home.family_planner.meals.resource;

import org.springframework.hateoas.ResourceSupport;

public class MealResource extends ResourceSupport {
	
	private Long id;
	
	private String title;
	
	private String description;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
