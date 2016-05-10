package home.family_planner.meals.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import home.family_planner.meals.models.FoodProduct;

@Repository
public class FoodProductRepository implements CrudRepository<FoodProduct, Long>{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public <S extends FoodProduct> S save(S entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public FoodProduct findOne(Long id) {
		return (FoodProduct) entityManager.createQuery("from FoodProduct where id = :id")
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		entityManager.createQuery("delete FoodProduct where id = :id")
		.setParameter("id", id)
		.executeUpdate();
	}

	@Override
	public void delete(FoodProduct entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends FoodProduct> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodProduct> findAll() {
		return (List<FoodProduct>) entityManager
				.createQuery("from FoodProduct")
				.getResultList();
	}

	@Override
	public List<FoodProduct> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FoodProduct> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

}
