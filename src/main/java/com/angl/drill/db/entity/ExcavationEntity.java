package com.angl.drill.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = ExcavationEntity.COLLECTION_NAME)
public class ExcavationEntity {
    public static final String COLLECTION_NAME = "excavation";

    @JsonIgnore
    @Id
    private String id;

    private Integer time;
    private Integer exc;

    public ExcavationEntity() {
    }

    public ExcavationEntity(Integer excavation, Integer time) {
        this.exc = excavation;
        this.time = time;
    }

    public Integer getExc() {
        return exc;
    }

    public Integer getTime() {
        return time;
    }

    public String getId() {
        return id;
    }


}
