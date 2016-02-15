package com.angl.drill.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = ExcavationSession.EXCAVATION_SESSION_COLLECTION_NAME)
public class ExcavationSession {
    public static final String EXCAVATION_SESSION_COLLECTION_NAME = "excavation_sessions";

    @Id
    @JsonIgnore
    private ObjectId id;

    @Field(value = "session")
    private int sessionNumber;

    @Field(value = "is_experiment")
    private boolean isExperiment;

    @Field(value = "drill_speed")
    private double drillSpeed;

    @Field(value = "wear_rate")
    private double wearRate;

    @Field(value = "predictable_cost")
    private double predictableCost;

    @Field(value = "predictable_drill_time")
    private double predictableDrillTime;

    @Field(value = "bit_load")
    private double bitLoad;

    @Field(value = "drill_hole")
    private ObjectId drillHoleId;

    public ObjectId getDrillHoleId() {
        return drillHoleId;
    }

    public void setDrillHoleId(ObjectId drillHoleId) {
        this.drillHoleId = drillHoleId;
    }

    private List<Excavation> excavation;

    public List<Excavation> getExcavation() {
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

    public void setExcavation(List<Excavation> excavation) {
        this.excavation = excavation;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public double getDrillSpeed(){ return drillSpeed; }

    public double getWearRate(){ return wearRate; }

    public void setDrillSpeed(double drillSpeed) { this.drillSpeed = drillSpeed; }

    public void setWearRate(double wearRate) { this.wearRate = wearRate; }

    public double getPredictableCost() { return predictableCost; }

    public void setPredictableCost(double cost) { this.predictableCost = predictableCost; }

    public double getBitLoad() { return bitLoad; }

    public void setBitLoad(double bitLoad) { this.bitLoad = bitLoad; }

    public double getPredictableDrillTime() { return predictableDrillTime; }

    public void setPredictableDrillTime(double predictableDrillTime) { this.predictableDrillTime = predictableDrillTime; }

}
