package home.family_planner.meals.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import home.family_planner.meals.model.Receipt;

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
	
}
