package de.matech.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

public interface JsonObject {
    Logger LOGGER = Logger.getLogger(JsonObject.class);

    default String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOGGER.error("Can't write json-string!", e);
            return "{}";
        }
    }
}
