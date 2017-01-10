package home.family_planner.planner.controller;

import java.util.List;

import javax.transaction.Transactional;

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

import home.family_planner.planner.helper.FoodProductAssembler;
import home.family_planner.planner.model.FoodProduct;
import home.family_planner.planner.repository.FoodProductRepository;
import home.family_planner.planner.resource.FoodProductResource;

@CrossOrigin
@RestController
@RequestMapping("/foodProducts")
public class FoodProductController {
	
	@Autowired
	FoodProductRepository repository;

    @Transactional
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody FoodProductResource add(@RequestBody FoodProduct input) {
		repository.save(input);
        return new FoodProductAssembler().toResource(input);
    }
    
    @Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
    public 	@ResponseBody FoodProductResource update(@PathVariable("id") Long id, @RequestBody FoodProduct input) {
    	FoodProduct foodProduct = getAndValidateFoodProduct(id);
    	foodProduct.setTitle(input.getTitle());
    	foodProduct.setDescription(input.getDescription());
    	foodProduct.setPrice(input.getPrice());
		repository.save(foodProduct);
        return new FoodProductAssembler().toResource(foodProduct);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody FoodProductResource get(@PathVariable("id") Long id) {
		FoodProduct foodProduct = getAndValidateFoodProduct(id);
        return new FoodProductAssembler().toResource(foodProduct);
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<FoodProductResource> foods() {
        return new FoodProductAssembler().toResources(repository.findAll());
    }
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
		getAndValidateFoodProduct(id);
        repository.delete(id);
    }
	
	private FoodProduct getAndValidateFoodProduct(Long id) {
		FoodProduct fp = this.repository.findOne(id).orElseThrow(() -> new FoodProductNotFoundException(id));
		return fp;
	}

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class FoodProductNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FoodProductNotFoundException(Long id) {
		super("could not find food product '" + id + "'.");
	}
}
