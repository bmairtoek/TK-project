package pl.edu.agh.tk.project.datastorageservice.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.tk.project.datastorageservice.database.MongoConnector;
import pl.edu.agh.tk.project.datastorageservice.model.TemperatureMeasurement;

@RestController
public class TemperatureReadingService {

    private Logger logger = LoggerFactory.getLogger(TemperatureReadingService.class);

    private MongoConnector mongoConnector = new MongoConnector();

    @PostMapping("/measurement/temperature")
    public ResponseEntity getMeasurement(@RequestBody TemperatureMeasurement temperatureMeasurement) {
        logger.info("Received: ".concat(temperatureMeasurement.toString()));
        mongoConnector.insertToDB(temperatureMeasurement);
        return ResponseEntity.ok().build();
    }
}
