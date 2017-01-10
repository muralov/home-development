package home.family_planner.planner;

import com.mongodb.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.UnknownHostException;

@EnableSwagger2
@SpringBootApplication
@ComponentScan
public class Application {

    //	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        testMongoDB();
    }

    private static void testSpringData() {

    }

    private static void testMongoDB() {
    // To directly connect to a single MongoDB server (note that this will not auto-discover the primary even
    // if it's a member of a replica set:
        MongoClient mongoClient = null;
        mongoClient = new MongoClient("localhost", 27017);


        DB db = mongoClient.getDB("myTest");
        DBCollection coll = db.getCollection("plans");
//        BasicDBObject doc = new BasicDBObject("name", "MongoDB")
//                .append("type", "database")
//                .append("count", 1)
//                .append("info", new BasicDBObject("x", 203).append("y", 102));
//        coll.insert(doc);

        DBObject myDoc = coll.findOne();
        System.out.println(myDoc);
//
//        for (int i=0; i < 100; i++) {
//            coll.insert(new BasicDBObject("i", i));
//        }

        System.out.println(coll.getCount());

        BasicDBObject query = new BasicDBObject("i", 71);

        DBCursor cursor = coll.find(query);

        try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }

        query = new BasicDBObject("i", new BasicDBObject("$ne", 3)
                .append("$lt", 10));

        cursor = coll.find(query);

        try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }

}
