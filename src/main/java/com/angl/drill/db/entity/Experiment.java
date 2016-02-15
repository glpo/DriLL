package com.angl.drill.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = Experiment.EXPERIMENT_COLLECTION_NAME)
public class Experiment {
    public final static String EXPERIMENT_COLLECTION_NAME = "experiments";

    @Id
    @JsonIgnore
    private ObjectId id;

    private String name;

    @Field(value = "break_by")
    private String breakBy;

    @Field(value = "bit_load")
    private int bitLoad;

    @Field(value = "delta_load")
    private int bitDeltaLoad;

    @Field(value = "per_hour")
    private int costPerHour;

    @Field(value = "bit_cost")
    private int bitCost;

    @Field(value = "desc_asc_time")
    private int descAscTime;

    @Field(value = "break_param_val")
    private int breakParamValue;

    @Field(value = "optimum_bit_load")
    private double optimumBitLoad;

    @Field(value = "predictable_drill_cost")
    private double predictableDrillCost;

    @Field(value = "session")
    private ObjectId sessionId;

    public ObjectId getSessionId() {
        return sessionId;
    }

    public void setSessionId(ObjectId sessionId) {
        this.sessionId = sessionId;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreakBy() {
        return breakBy;
    }

    public int getBitLoad() {
        return bitLoad;
    }

    public int getBitDeltaLoad() {
        return bitDeltaLoad;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public int getBitCost() {
        return bitCost;
    }

    public int getDescAscTime() {
        return descAscTime;
    }

    public int getBreakParamValue() {
        return breakParamValue;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreakBy(String breakBy) {
        this.breakBy = breakBy;
    }

    public void setBitLoad(int bitLoad) {
        this.bitLoad = bitLoad;
    }

    public void setBitDeltaLoad(int bitDeltaLoad) {
        this.bitDeltaLoad = bitDeltaLoad;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public void setBitCost(int bitCost) {
        this.bitCost = bitCost;
    }

    public void setDescAscTime(int descAscTime) {
        this.descAscTime = descAscTime;
    }

    public void setBreakParamValue(int breakParamValue) {
        this.breakParamValue = breakParamValue;
    }

    public double getOptimumBitLoad() { return optimumBitLoad; }

    public void setOptimumBitLoad(double optimumBitLoad) { this.optimumBitLoad = optimumBitLoad; }

    public double getPredictableDrillCost() { return predictableDrillCost; }

    public void setPredictableDrillCost(double predictableDrillCost) { this.predictableDrillCost = predictableDrillCost; }
}
