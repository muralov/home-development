package home.family_planner.meals.controller;

import home.family_planner.meals.helper.PlanResourceAssembler;
import home.family_planner.meals.model.Plan;
import home.family_planner.meals.repository.PlanRepository;
import home.family_planner.meals.resource.PlanResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by mansur on 12/20/16.
 */
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:8080", "chrome-extension://ljlmonadebogfjabhkppkoohjkjclfai"})
@RestController
@RequestMapping("/plans")
public class PlanController {

    public static final String MEALS_REL = "meals";

    @Autowired
    PlanRepository repository;

    @Transactional
    @RequestMapping(method= RequestMethod.POST)
    public @ResponseBody
    PlanResource add(@RequestBody PlanResource input) {
        PlanResourceAssembler assembler = new PlanResourceAssembler();
        Plan plan = assembler.toEntity(input);
        repository.save(plan);
        return new PlanResourceAssembler().toResource(plan);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody PlanResource get(@PathVariable("id") Long id) {
        Plan plan = getAndValidateMeal(id);
        PlanResource pr = new PlanResourceAssembler().toResource(plan);
        Link link = new Link("http://localhost:8080/meals/" + plan.getMealPlanPK().getMealId(), MEALS_REL);
        pr.add(link);

        return pr;
    }

    private Plan getAndValidateMeal(Long id) {
        return repository.findOne(id).orElseThrow(() -> new PlanNotFoundException(id));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class PlanNotFoundException  extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public PlanNotFoundException(Long id) {
            super("could not find plan '" + id + "'.");
        }
    }
}
