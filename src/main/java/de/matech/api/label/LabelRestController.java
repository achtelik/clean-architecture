package de.matech.api.label;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class LabelRestController {

    private static final Logger LOGGER = Logger.getLogger(LabelJson.class);

    private static final HashMap<String, LabelJson> labelsJsons = new HashMap<>();

    @PostMapping
    public ResponseEntity<LabelJson> crateLabel(@RequestBody LabelJson labelJson) {
        LOGGER.info("LabelRestController.crateLabel = " + labelJson.toJson());
        labelsJsons.put(labelJson.id, labelJson);
        return new ResponseEntity<>(labelJson, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<LabelJson>> getLabels() {
        LOGGER.info("LabelRestController.getLabels");
        return new ResponseEntity<>(labelsJsons.values(), HttpStatus.CREATED);
    }
}
