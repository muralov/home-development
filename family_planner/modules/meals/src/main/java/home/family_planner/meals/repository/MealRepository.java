package home.family_planner.meals.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import home.family_planner.meals.model.Meal;

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
