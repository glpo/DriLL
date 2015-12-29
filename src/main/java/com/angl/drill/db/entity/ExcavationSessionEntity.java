package com.angl.drill.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = ExcavationSessionEntity.EXCAVATION_SESSION_COLLECTION_NAME)
public class ExcavationSessionEntity {
    public static final String EXCAVATION_SESSION_COLLECTION_NAME = "excavation_sessions";

    @Id
    @JsonIgnore
    private ObjectId id;

    @Field(value = "session")
    private int sessionNumber;

    @Field(value = "is_experiment")
    private boolean isExperiment;

    private List<ExcavationEntity> excavation;

    public List<ExcavationEntity> getExcavation() {
        return excavation;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public boolean isExperiment() {
        return isExperiment;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public void setIsExperiment(boolean isExperiment) {
        this.isExperiment = isExperiment;
    }

    public void setExcavation(List<ExcavationEntity> excavation) {
        this.excavation = excavation;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
