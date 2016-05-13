package home.family_planner.meals.resource;

import java.util.List;
import org.springframework.hateoas.Link;

import com.fasterxml.jackson.annotation.JsonCreator;

public class MealResource  {
	
	private Long id;
	
	private String title;
	
	private String description;
	
	private Link receipt;
	
	private List<Link> foodProducts;
	
	@JsonCreator
	public MealResource(Long id, String title, String description, Link receipt, List<Link> foodProducts) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.receipt = receipt;
		this.foodProducts = foodProducts;
	}
	
	public Long getId() {
		return id;
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

	public Link getReceipt() {
		return receipt;
	}

	public void setReceipt(Link receipt) {
		this.receipt = receipt;
	}

	public List<Link> getFoodProducts() {
		return foodProducts;
	}

	public void setFoodProducts(List<Link> foodProducts) {
		this.foodProducts = foodProducts;
	}

}
