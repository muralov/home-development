package home.family_planner.meals.controller;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import home.family_planner.meals.model.FoodProduct;
import home.family_planner.meals.model.Meal;
import home.family_planner.meals.repository.MealRepository;
import home.family_planner.meals.resource.MealResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/meals")
public class MealController {
	
	@Autowired
	MealRepository repository;
	
    @Transactional
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody MealResource add(@RequestBody MealResource input) {
//		repository.save(input);
    	
    	
    	
        return input;
    }
    
    @Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
    public 	@ResponseBody Meal update(@PathVariable("id") Long id, @RequestBody Meal input) {
    	Meal meal = repository.findOne(id).orElseThrow(() -> new ReceiptNotFoundException(id));
    	meal.setTitle(input.getTitle());
    	meal.setDescription(input.getDescription());
    	meal.setReceipt(input.getReceipt());
    	meal.setFoodProducts(input.getFoodProducts());
		repository.save(meal);
        return meal;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody MealResource get(@PathVariable("id") Long id) {
    	Meal meal = repository.findOne(id).orElseThrow(() -> new ReceiptNotFoundException(id));
    	List<Link> fps = new ArrayList<>();
    	fps.add(linkTo(methodOn(FoodProductController.class).get(Long.valueOf(1))).withRel("food product"));
    	fps.add(linkTo(methodOn(FoodProductController.class).get(Long.valueOf(2))).withRel("food product"));
    	Link receipt = linkTo(methodOn(ReceiptController.class).get(Long.valueOf(1))).withRel("receipt");
    	return new MealResource(id, meal.getTitle(), meal.getDescription(), receipt, fps);
//        return repository.findOne(id).orElseThrow(() -> new MealNotFoundException(id));
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<Meal> foods() {
        return repository.findAll();
    }
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
		validateFoodProduct(id);
		repository.delete(id);
    }
	
	@RequestMapping(value="/{id}/foodProducts", method=RequestMethod.GET)
    public @ResponseBody List<FoodProduct> getFoodProducts(@PathVariable("id") Long id) {
        return repository.findOne(id).orElseThrow(() -> new ReceiptNotFoundException(id)).getFoodProducts();
    }
	
	@RequestMapping(value="/{id}/foodProducts/{foodProductId}", method=RequestMethod.PUT)
    public @ResponseBody FoodProduct addFoodProduct(@PathVariable("id") Long id, @PathVariable("id") Long foodProductId) {
		//TODO: implementation
        return null;
    }
	
	@RequestMapping(value="/{id}/foodProducts/{foodProductId}", method=RequestMethod.DELETE)
    public void deleteFoodProduct(@PathVariable("id") Long id, @PathVariable("id") Long foodProductId) {
		//TODO: implementation
    }
	
	private void validateFoodProduct(Long id) {
		this.repository.findOne(id).orElseThrow(() -> new ReceiptNotFoundException(id));
	}

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class MealNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MealNotFoundException(Long id) {
		super("could not find meal '" + id + "'.");
	}
}