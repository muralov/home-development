package home.family_planner.meals.repository;

import home.family_planner.meals.model.Plan;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Created by mansur on 12/20/16.
 */
@Repository
public class PlanRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Plan save(Plan plan) {
        entityManager.persist(plan);
        return plan;
    }

    public Optional<Plan> findOne(Long id) {
        Plan meal = (Plan) entityManager.createQuery("from Plan where planId = :id")
                .setParameter("id", id)
                .getSingleResult();
        return Optional.of(meal);
    }

    public void delete(Long id) {
        entityManager.createQuery("delete Plan where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Plan> findAll() {
        return entityManager
                .createQuery("from Plan")
                .getResultList();
    }
}
