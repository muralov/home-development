package home.family_planner.planner.database;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by mansur on 1/8/17.
 */
@Configuration
public class MongoConnection {

    @Value("${mongodb.hostname}")
    private String hostname;

    @Value("${mongodb.port}")
    private int port;

    @Value("${mongodb.database}")
    private String database;

    public @Bean MongoClient mongoClient() {
        return new MongoClient(hostname, port);
    }

    public @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }
}
