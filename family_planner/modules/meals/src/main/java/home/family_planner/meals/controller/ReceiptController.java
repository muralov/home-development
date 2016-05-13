package home.family_planner.meals.controller;

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

import home.family_planner.meals.model.Receipt;
import home.family_planner.meals.repository.ReceiptRepository;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
	
	@Autowired
	ReceiptRepository repository;
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Receipt add(@RequestBody Receipt input) {
		repository.save(input);
        return input;
    }
	
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody Receipt get(@PathVariable("id") Long id) {
        return repository.findOne(id).orElseThrow(() -> new ReceiptNotFoundException(id));
    }

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class ReceiptNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ReceiptNotFoundException(Long id) {
		super("could not find receipt '" + id + "'.");
	}
}
