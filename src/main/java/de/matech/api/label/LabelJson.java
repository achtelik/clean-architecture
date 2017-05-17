package de.matech.api.label;

import de.matech.api.JsonObject;
import de.matech.persistence.LabelEntity;

class LabelJson implements JsonObject{
    public String id;
    public String name;

    public LabelJson(LabelEntity pLabelEntity) {
        id = pLabelEntity.id.toString();
        name = pLabelEntity.name;
    }
}