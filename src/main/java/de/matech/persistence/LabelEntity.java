package de.matech.persistence;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class LabelEntity {

    @Id
    public UUID id;
    public String name;

    public LabelEntity() {
    }

    public LabelEntity(String pName) {
        id = UUID.randomUUID();
        name = pName;
    }
}
