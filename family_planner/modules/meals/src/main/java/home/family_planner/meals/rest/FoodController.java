package home.family_planner.meals.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
	
	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
