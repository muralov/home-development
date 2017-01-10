package home.family_planner.planner.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import home.family_planner.planner.model.Receipt;

@Repository
public class ReceiptRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Receipt save(Receipt receipt) {
		entityManager.persist(receipt);
		return receipt;
	}
	
	public Optional<Receipt> findOne(Long id) {
		Receipt receipt = (Receipt) entityManager.createQuery("from Receipt where id = :id")
				.setParameter("id", id)
				.getSingleResult();
		return Optional.of(receipt);
	}
	
	public void delete(Long id) {
		entityManager.createQuery("delete Receipt where id = :id")
		.setParameter("id", id)
		.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Receipt> findAll() {
		return entityManager
				.createQuery("from Receipt")
				.getResultList();
	}
	
}
