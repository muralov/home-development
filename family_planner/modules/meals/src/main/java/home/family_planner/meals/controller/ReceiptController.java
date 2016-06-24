package home.family_planner.meals.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import home.family_planner.meals.helper.MealResourceAssembler;
import home.family_planner.meals.helper.ReceiptResourceAssembler;
import home.family_planner.meals.model.Receipt;
import home.family_planner.meals.repository.ReceiptRepository;
import home.family_planner.meals.resource.MealResource;
import home.family_planner.meals.resource.ReceiptResource;

@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:8080"})
@RestController
@RequestMapping("/receipts")
public class ReceiptController {
	
	@Autowired
	ReceiptRepository repository;
	
	private ReceiptResourceAssembler assembler = new ReceiptResourceAssembler();
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody ReceiptResource add(@RequestBody Receipt input) {
		repository.save(input);
        return assembler.toResource(input);
    }
	
	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<ReceiptResource> receipts() {
        return repository.findAll().stream()
        		.map(receipt -> assembler.toResource(receipt))
        		.collect(Collectors.toList());
    }
	
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody ReceiptResource get(@PathVariable("id") Long id) {
        Receipt receipt = repository.findOne(id).orElseThrow(() -> new ReceiptNotFoundException(id));
        return assembler.toResource(receipt);
    }
    
    @Transactional
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        repository.findOne(id).orElseThrow(() -> new ReceiptNotFoundException(id));
        repository.delete(id);
    }

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class ReceiptNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ReceiptNotFoundException(Long id) {
		super("could not find receipt '" + id + "'.");
	}
}
