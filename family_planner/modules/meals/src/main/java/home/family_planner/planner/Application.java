package home.family_planner.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan
public class Application {
	
//	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
//	@Autowired 
//	FoodProductRepository repository;
//	
//	@Bean
//	public CommandLineRunner demo() {
//		return (args) -> {
//			// save a couple of customers
//			repository.save(new FoodProduct("Carrot",  "Carrot is vegetable and has a yellow color.", 1.00));
//			repository.save(new FoodProduct("Potatoe",  "Potatoe is vegetable and has a light brown color.", 0.75));
//			repository.save(new FoodProduct("Bread",  "Bread should be cooked. It contains flour, water, etc.", 0.80));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (FoodProduct customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//            log.info("");
//
//			// fetch an individual customer by ID
//			FoodProduct customer = repository.findOne(1L);
//			log.info("Customer found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//            log.info("");
//		};
//	}

}
