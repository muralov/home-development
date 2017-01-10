package home.family_planner.planner.repository;

import home.family_planner.planner.model.PlanMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by mansur on 12/20/16.
 */

public interface PlanRepository extends MongoRepository<PlanMongo, Long> {

}
