package home.family_planner.meals.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import home.family_planner.meals.model.FoodProduct;
import home.family_planner.meals.repository.FoodProductRepository;

@RestController
@RequestMapping("/foodProducts")
public class FoodProductController {
	
	public final static String RESPONSE = "{\"id\":1,\"title\":\"Palov\"}";
	
	@Autowired
	FoodProductRepository foodProductRepository;

    @Transactional
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody FoodProduct add(@RequestBody FoodProduct input) {
		foodProductRepository.save(input);
        return input;
    }
    
    @Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
    public 	@ResponseBody FoodProduct update(@PathVariable("id") Long id, @RequestBody FoodProduct input) {
    	validateFoodProduct(id);
    	FoodProduct foodProduct = foodProductRepository.findOne(id);
    	foodProduct.setTitle(input.getTitle());
    	foodProduct.setDescription(input.getDescription());
    	foodProduct.setPrice(input.getPrice());
		foodProductRepository.save(foodProduct);
        return foodProduct;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody FoodProduct get(@PathVariable("id") Long id) {
		validateFoodProduct(id);
        return foodProductRepository.findOne(id);
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<FoodProduct> foods() {
        return foodProductRepository.findAll();
    }
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
		validateFoodProduct(id);
        foodProductRepository.delete(id);
    }
	
	private void validateFoodProduct(Long id) {
		this.foodProductRepository.findOne(id);
	}

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class FoodProductNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FoodProductNotFoundException(Long id) {
		super("could not find food product '" + id + "'.");
	}
}
