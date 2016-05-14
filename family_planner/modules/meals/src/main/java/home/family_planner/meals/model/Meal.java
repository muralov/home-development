package home.family_planner.meals.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Meal extends Food {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne (cascade= CascadeType.ALL)
	@JoinColumn (name="receipt_id")
	private Receipt receipt = null;
	
	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="meal_id", nullable=false)
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
