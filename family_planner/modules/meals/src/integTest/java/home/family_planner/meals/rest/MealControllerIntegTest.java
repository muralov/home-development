package home.family_planner.meals.rest;

import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import home.family_planner.meals.Application;
import home.family_planner.meals.resource.FoodProductResource;
import home.family_planner.meals.resource.MealResource;
import home.family_planner.meals.resource.ReceiptResource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class MealControllerIntegTest {
	
	@Value("${local.server.port}")
    private int port;

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		template = new TestRestTemplate();
	}
	
	@Test
	public void getMeal() throws Exception {
		this.base = new URL("http://localhost:" + port + "/meals/1");

		Traverson tr = new Traverson(this.base.toURI(), MediaTypes.HAL_JSON);
		MealResource mr = tr.follow("self").toEntity(MealResource.class).getBody();
		List<FoodProductResource> foodProducts = tr.follow("food products").toEntity(List.class).getBody();
		ReceiptResource receipt = tr.follow("receipt").toEntity(ReceiptResource.class).getBody();
		String description = tr.follow("receipt").toObject("$.description");
		
		
//		assertThat(response.getBody(), equalTo(FoodProductController.RESPONSE));
	}
	
	@Test
	public void addMeal() throws Exception {
		this.base = new URL("http://localhost:" + port + "/meals/1");
		ResponseEntity<MealResource> response = template.getForEntity(base.toString(), MealResource.class);
		MealResource m = response.getBody();
		
//		assertThat(response.getBody(), equalTo(FoodProductController.RESPONSE));
	}

}
