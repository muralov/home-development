package home.family_planner.planner.repository;

import com.mongodb.MongoClient;
import home.family_planner.planner.database.MongoConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;


/**
 * Created by mansur on 1/8/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MongoConnection.class)
public class MongoDBConnectionTest {

    @Autowired
    private MongoClient mongoClient;

    @Test
    public void testMongoDBConnection() {
        assertNotNull("the bean must have been registered", mongoClient);
    }

}
