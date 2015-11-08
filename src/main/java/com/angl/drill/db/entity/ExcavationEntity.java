package com.angl.drill.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = ExcavationEntity.COLLECTION_NAME)
public class ExcavationEntity {
    public static final String COLLECTION_NAME = "excavation";

    @Id
    private String id;

    private Integer excavation;
    private Integer time;

    public ExcavationEntity() {
    }

    public ExcavationEntity(Integer excavation, Integer time) {
        this.excavation = excavation;
        this.time = time;
    }

    public Integer getExcavation() {
        return excavation;
    }

    public Integer getTime() {
        return time;
    }


}
