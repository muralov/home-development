package home.family_planner.planner.controller;

import home.family_planner.planner.model.PlanMongo;
import home.family_planner.planner.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mansur on 12/20/16.
 */
@CrossOrigin
@RestController
@RequestMapping("/plans")
public class PlanController {

    public static final String MEALS_REL = "planner";

    @Autowired
    PlanRepository repository;

    @RequestMapping(method= RequestMethod.POST)
    public @ResponseBody
    PlanMongo add(@RequestBody PlanMongo input) {
        repository.save(input);
        return input;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody
    PlanMongo get(@PathVariable("id") String id) {
        return getAndValidateMeal(new Long(id));
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    List<PlanMongo> getPlans() {
        return repository.findAll();
    }

    private PlanMongo getAndValidateMeal(Long id) {
        PlanMongo plan = repository.findOne(id);
        if(plan == null)
            throw new PlanNotFoundException(String.valueOf(id));
        return plan;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class PlanNotFoundException  extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public PlanNotFoundException(String id) {
            super("could not find plan '" + id + "'.");
        }
    }
}
