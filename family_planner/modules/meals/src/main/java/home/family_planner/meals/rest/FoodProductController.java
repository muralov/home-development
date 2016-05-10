package home.family_planner.meals.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import home.family_planner.meals.models.FoodProduct;
import home.family_planner.meals.repository.FoodProductRepository;

@RestController
@RequestMapping("/foodProducts")
public class FoodProductController {
	
	public final static String RESPONSE = "{\"id\":1,\"title\":\"Palov\"}";
	
	@Autowired
	FoodProductRepository foodProductRepository;

    @Transactional
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
    public FoodProduct add(FoodProduct foodProduct) {
    	foodProduct = new FoodProduct("Carrot",  "Carrot is vegetable and has a yellow color.", 1.00);
		foodProductRepository.save(foodProduct);
        return foodProduct;
    }
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
    public List<FoodProduct> foods() {
        return foodProductRepository.findAll();
    }
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody
    public void delete(@PathVariable("id") Long id) {
        foodProductRepository.delete(id);
    }

}
