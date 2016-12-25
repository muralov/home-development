package home.family_planner.meals.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Meal extends Food {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@OneToOne (cascade= CascadeType.ALL)
	@JoinColumn (name="receipt_id")
	private Receipt receipt = null;

	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "meal_food_products",
			joinColumns = @JoinColumn(name = "meal_id"),
			inverseJoinColumns = @JoinColumn(name = "food_products_id"),
			uniqueConstraints = @UniqueConstraint(columnNames={"meal_id", "food_products_id"})
	)
	private List<FoodProduct> foodProducts = new ArrayList<>();
	
	public Meal() {}

	public Meal(Receipt receipt, List<FoodProduct> foodProducts) {
		this.receipt = receipt;
		this.foodProducts = foodProducts;
	}

	public long getId() {
		return id;
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
