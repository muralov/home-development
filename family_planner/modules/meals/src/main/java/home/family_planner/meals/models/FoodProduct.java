package home.family_planner.meals.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodProduct extends Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private double price;
	
	public FoodProduct() {}

	public FoodProduct(String title, String description, double price) {
		super(title, description);
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format(
                "Customer[id=%d, title='%s', description='%s', price='%d']",
                id, getTitle(), getDescription(), getPrice());
	}
}
