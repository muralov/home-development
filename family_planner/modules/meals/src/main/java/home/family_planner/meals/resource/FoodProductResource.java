package home.family_planner.meals.resource;

import org.springframework.hateoas.ResourceSupport;

public class FoodProductResource extends ResourceSupport{

	private String title;
	
	private String description;
	
	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
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
