package home.family_planner.meals.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import home.family_planner.meals.model.FoodProduct;

@Repository
public class FoodProductRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public <S extends FoodProduct> S save(S entity) {
		entityManager.persist(entity);
		return entity;
	}

	public Optional<FoodProduct> findOne(Long id) {
		FoodProduct fp = (FoodProduct) entityManager.createQuery("from FoodProduct where id = :id")
				.setParameter("id", id)
				.getSingleResult();
		return Optional.of(fp);
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Long id) {
		entityManager.createQuery("delete FoodProduct where id = :id")
		.setParameter("id", id)
		.executeUpdate();
	}

	public void delete(FoodProduct entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends FoodProduct> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<FoodProduct> findAll() {
		return (List<FoodProduct>) entityManager
				.createQuery("from FoodProduct")
				.getResultList();
	}

	public List<FoodProduct> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends FoodProduct> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

}
