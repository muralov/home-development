package home.family_planner.planner.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import home.family_planner.planner.model.Meal;

@Repository
public class MealRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Meal save(Meal meal) {
		entityManager.persist(meal);
		return meal;
	}
	
	public Optional<Meal> findOne(Long id) {
		Meal meal = (Meal) entityManager.createQuery("from Meal where id = :id")
				.setParameter("id", id)
				.getSingleResult();
		return Optional.of(meal);
	}

//	public Optional<List<FoodProduct>> getMealProducts(Long id) {
//		Optional<List<FoodProduct>> f
//		(FoodProduct) entityManager.createQuery("from FoodProduct where id = :id")
//				.setParameter("id", id)
//	}
	
	public void delete(Long id) {
		entityManager.createQuery("delete Meal where id = :id")
		.setParameter("id", id)
		.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Meal> findAll() {
		return entityManager
				.createQuery("from Meal")
				.getResultList();
	}

}
