package home.family_planner.meals.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import home.family_planner.meals.helper.MealResourceAssembler;
import home.family_planner.meals.model.FoodProduct;
import home.family_planner.meals.model.Meal;
import home.family_planner.meals.repository.MealRepository;
import home.family_planner.meals.resource.MealResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/meals")
public class MealController {
	
	private static final String FOOD_PRODUCTS_REL = "food products";
	private static final String RECEIPT_REL = "receipt";
	
	@Autowired
	MealRepository repository;
	
    @Transactional
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody MealResource add(@RequestBody Meal input) {
    	repository.save(input);
    	return new MealResourceAssembler().toResource(input);
    }
    
    @Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
    public 	@ResponseBody MealResource update(@PathVariable("id") Long id, @RequestBody Meal input) {
    	Meal meal = getAndValidateMeal(id);
    	meal.setTitle(input.getTitle());
    	meal.setDescription(input.getDescription());
    	meal.setFoodProducts(input.getFoodProducts());
    	meal.setReceipt(input.getReceipt());
    	repository.save(input);
    	return new MealResourceAssembler().toResource(input);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody MealResource get(@PathVariable("id") Long id) {
    	Meal meal = repository.findOne(id).orElseThrow(() -> new ReceiptNotFoundException(id));
    	MealResource mr = new MealResourceAssembler().toResource(meal);
    	mr.add(linkTo(methodOn(MealController.class).getFoodProducts(id)).withRel(FOOD_PRODUCTS_REL));
    	mr.add(linkTo(methodOn(ReceiptController.class).get(Long.valueOf(1))).withRel(RECEIPT_REL));
		return mr;
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<MealResource> foods() {
		MealResourceAssembler assembler = new MealResourceAssembler();
        return repository.findAll().stream()
        		.map(meal -> assembler.toResource(meal))
        		.collect(Collectors.toList());
    }
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
		getAndValidateMeal(id);
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
	
	private Meal getAndValidateMeal(Long id) {
		return repository.findOne(id).orElseThrow(() -> new ReceiptNotFoundException(id));
	}

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class MealNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MealNotFoundException(Long id) {
		super("could not find meal '" + id + "'.");
	}
}