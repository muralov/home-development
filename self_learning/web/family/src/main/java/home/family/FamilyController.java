package home.family;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController {
	
    @RequestMapping("/family")
    public Family family(@RequestParam(value="name", defaultValue="Uralov") String name,
    		@RequestParam(value="location", defaultValue="Germany") String locaton) {
        return new Family(name, LocalDate.of(2014, Month.OCTOBER, 16), locaton);
    }

}
