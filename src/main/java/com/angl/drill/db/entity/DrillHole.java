package com.angl.drill.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = DrillHole.DRILL_HOLE_COLLECTION_NAME)
public class DrillHole {
    public final static String DRILL_HOLE_COLLECTION_NAME = "drill_holes";

    @Id
    @JsonIgnore
    String objectId;

    private String name;

    private String location;

    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
