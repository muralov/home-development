package home.family_planner.meals.models;

import java.util.List;

public abstract class Meal extends Food {

	private Receipt receipt;
	private List<FoodProduct> foodProducts;
	
	public Meal() {}

	public Meal(Receipt receipt, List<FoodProduct> foodProducts) {
		super();
		this.receipt = receipt;
		this.foodProducts = foodProducts;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public List<FoodProduct> getFoodProducts() {
		return foodProducts;
	}

	public void setFoodProducts(List<FoodProduct> foodProducts) {
		this.foodProducts = foodProducts;
	}
}
