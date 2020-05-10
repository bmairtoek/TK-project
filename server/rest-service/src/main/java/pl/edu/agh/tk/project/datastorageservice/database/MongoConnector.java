package pl.edu.agh.tk.project.datastorageservice.database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.tk.project.datastorageservice.model.TemperatureMeasurement;

public class MongoConnector {

    private Logger logger = LoggerFactory.getLogger(MongoConnector.class);

    private MongoClient mongoClient = null;

    public void insertToDB(TemperatureMeasurement temperatureMeasurement) {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("dataStorageAppDB");

        MongoCollection<BasicDBObject> collection = mongoDatabase.getCollection("measurements_temperature", BasicDBObject.class);
        BasicDBObject document = prepareDocument(temperatureMeasurement);

        collection.insertOne(document);
        logger.info("Inserted to database: " + document.toString());
    }

    private MongoClient getMongoClient() {
        if (mongoClient == null) {
            mongoClient = new MongoClient();
        }
        return mongoClient;
    }

    private BasicDBObject prepareDocument(TemperatureMeasurement temperatureMeasurement) {
        return new BasicDBObject("date", temperatureMeasurement.getDate())
                .append("value", temperatureMeasurement.getValue())
                .append("deviceId", temperatureMeasurement.getDeviceId());
    }
}
