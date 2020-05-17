package pl.edu.agh.tk.project.datastorageservice.database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.tk.project.datastorageservice.model.TemperatureMeasurement;

public class MongoConnector {

    private final String DB_HOST_NAME = "mongo";
    private final String DB_NAME = "dataStorageAppDB1";
    private final String DB_COLLECTION_NAME = "measurements_temperature";

    private Logger logger = LoggerFactory.getLogger(MongoConnector.class);

    private MongoClient mongoClient = null;

    public void insertToDB(TemperatureMeasurement temperatureMeasurement) {
        MongoClient mongoClient = getMongoClient(DB_HOST_NAME);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(DB_NAME);

        MongoCollection<BasicDBObject> collection = mongoDatabase.getCollection(DB_COLLECTION_NAME, BasicDBObject.class);
        BasicDBObject document = prepareDocument(temperatureMeasurement);

        collection.insertOne(document);
        logger.info("Inserted to database: " + document.toString());
    }

    private MongoClient getMongoClient(String dbName) {
        if (mongoClient == null) {
            mongoClient = new MongoClient(dbName);
        }
        return mongoClient;
    }

    private BasicDBObject prepareDocument(TemperatureMeasurement temperatureMeasurement) {
        return new BasicDBObject("date", temperatureMeasurement.getDate())
                .append("value", temperatureMeasurement.getValue())
                .append("deviceId", temperatureMeasurement.getDeviceId());
    }
}
