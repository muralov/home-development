package home.family_planner.planner.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class FoodProductResource extends ResourceSupport{

	private long foodProductId;

	private String title;
	
	private String description;
	
	private double price;

	@JsonProperty("id")
	public long getFoodProductId() {
		return foodProductId;
	}

	public void setFoodProductId(long foodProductId) {
		this.foodProductId = foodProductId;
	}

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
