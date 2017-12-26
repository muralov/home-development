package home.family_planner.planner.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import home.family_planner.planner.helper.FoodProductAssembler;
import home.family_planner.planner.repository.FoodProductRepository;
import home.family_planner.planner.resource.FoodProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import home.family_planner.planner.helper.MealResourceAssembler;
import home.family_planner.planner.model.FoodProduct;
import home.family_planner.planner.model.Meal;
import home.family_planner.planner.repository.MealRepository;
import home.family_planner.planner.repository.ReceiptRepository;
import home.family_planner.planner.resource.MealResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@CrossOrigin
@RestController
@RequestMapping("/meals")
public class MealController {
	
	private static final String FOOD_PRODUCTS_REL = "foodProducts";
	private static final String RECEIPT_REL = "receipt";
	
	@Autowired
	MealRepository repository;
	
	@Autowired
	ReceiptRepository receiptRepository;

	@Autowired
	FoodProductRepository fpRepository;
	
	private MealResourceAssembler assembler = new MealResourceAssembler();
	
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
    	Meal meal = getAndValidateMeal(id);
    	MealResource mr = new MealResourceAssembler().toResource(meal);
    	mr.add(linkTo(methodOn(MealController.class).getFoodProducts(meal.getId())).withRel(FOOD_PRODUCTS_REL));
		if(meal.getReceipt() != null) {
			mr.add(linkTo(methodOn(ReceiptController.class).get(meal.getReceipt().getId())).withRel(RECEIPT_REL));
		}
		return mr;
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<MealResource> meals() {

		return repository.
				findAll().
				stream().
				map(m -> {
					MealResource mr = new MealResourceAssembler().toResource(m);
					mr.add(linkTo(methodOn(MealController.class).getFoodProducts(m.getId())).withRel(FOOD_PRODUCTS_REL));
					if(m.getReceipt() != null) {
						mr.add(linkTo(methodOn(ReceiptController.class).get(m.getReceipt().getId())).withRel(RECEIPT_REL));
					}
					return mr;
				}).
				collect(Collectors.toList());
    }

	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
		getAndValidateMeal(id);
		repository.delete(id);
    }
	
	@RequestMapping(value="/{id}/foodProducts", method=RequestMethod.GET)
    public @ResponseBody List<FoodProductResource> getFoodProducts(@PathVariable("id") Long id) {
        return new FoodProductAssembler().toResources(
        		repository.findOne(id).
						orElseThrow(() -> new ReceiptNotFoundException(id)).
						getFoodProducts()
		);
    }

	/**
	 * assigns a food product to the meal
	 * @param id of the meal
	 * @param foodProductId of the food product to be assigned to
	 * @return updated food product resource
	 */
	@Transactional
	@RequestMapping(value="/{id}/foodProducts/{foodProductId}", method=RequestMethod.PUT)
    public @ResponseBody MealResource assignFoodProduct(@PathVariable("id") Long id,
													   @PathVariable("foodProductId") Long foodProductId) {
		Meal meal = getAndValidateMeal(id);
		FoodProduct fp = fpRepository.findOne(foodProductId).orElseThrow(
				() -> new FoodProductNotFoundException(foodProductId));
		meal.getFoodProducts().add(fp);

        return new MealResourceAssembler().toResource(meal);
    }

	/**
	 * unassign food product from the meal
	 * @param id of the meal
	 * @param foodProductId of the food product to be unassigned
	 */
	@Transactional
	@RequestMapping(value="/{id}/foodProducts/{foodProductId}", method=RequestMethod.DELETE)
    public void deleteFoodProduct(@PathVariable("id") Long id,
								  @PathVariable("foodProductId") Long foodProductId) {
		Meal meal = getAndValidateMeal(id);
		meal.getFoodProducts().removeIf(x -> x.getId() == foodProductId);
    }

	/**
	 * adds new food product and assigns it to the meal
	 * @param id of the meal
	 * @return updated food product resource
	 */
	@Transactional
	@RequestMapping(value="/{id}/foodProducts", method=RequestMethod.POST)
	public @ResponseBody FoodProductResource addAndAssignFoodProduct(@PathVariable("id") Long id,
												@RequestBody FoodProduct input) {
		fpRepository.save(input);

		Meal meal = getAndValidateMeal(id);
		meal.getFoodProducts().add(input);

		return new FoodProductAssembler().toResource(input);
	}
	
	private Meal getAndValidateMeal(Long id) {
		return repository.findOne(id).orElseThrow(() -> new MealNotFoundException(id));
	}

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class MealNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MealNotFoundException(Long id) {
		super("could not find meal '" + id + "'.");
	}
}