package com.angl.drill.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Experiment.EXPERIMENT_COLLECTION_NAME)
public class Experiment {
    public final static String EXPERIMENT_COLLECTION_NAME = "experiments";

    @Id
    @JsonIgnore
    private ObjectId id;

    private String name;

    private String breakBy;

    private int bitLoad;

    private int bitDeltaLoad;

    private int costPerHour;

    private int bitCost;

    private int descAscTime;

    private int breakParamValue;

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
}
