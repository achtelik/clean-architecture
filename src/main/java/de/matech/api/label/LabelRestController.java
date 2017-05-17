package de.matech.api.label;

import de.matech.persistence.LabelEntity;
import de.matech.persistence.LabelRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class LabelRestController {

    private static final Logger LOGGER = Logger.getLogger(LabelJson.class);

    private final LabelRepository labelRepository;

    @Autowired
    public LabelRestController(LabelRepository pLabelRepository) {
        labelRepository = pLabelRepository;
    }

    @PostMapping
    public ResponseEntity<LabelJson> crateLabel(@RequestBody String labelName) {
        LOGGER.info("LabelRestController.crateLabel = " + labelName);
        LabelEntity labelEntity = labelRepository.save(new LabelEntity(labelName));
        return new ResponseEntity<>(new LabelJson(labelEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<LabelJson>> getLabels() {
        LOGGER.info("LabelRestController.getLabels");
        Collection<LabelJson> labelJsons = new HashSet<>();
        labelRepository.findAll().forEach(pLabelEntity -> labelJsons.add(new LabelJson(pLabelEntity)));
        return new ResponseEntity<>(labelJsons, HttpStatus.OK);
    }
}
