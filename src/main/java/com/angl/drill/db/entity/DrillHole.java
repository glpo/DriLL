package com.angl.drill.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = DrillHole.DRILL_HOLE_COLLECTION_NAME)
public class DrillHole {
    public final static String DRILL_HOLE_COLLECTION_NAME = "drill_holes";

    @Id
    @JsonIgnore
    private ObjectId id;

    private String name;

    private String location;

    @Field(value = "per_hour")
    private int costPerHour;

    @Field(value = "bit_cost")
    private int bitCost;

    @Field(value = "desc_asc_time")
    private int descAscTime;

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
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

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public int getBitCost() {
        return bitCost;
    }

    public void setBitCost(int bitCost) {
        this.bitCost = bitCost;
    }

    public int getDescAscTime() {
        return descAscTime;
    }

    public void setDescAscTime(int descAscTime) {
        this.descAscTime = descAscTime;
    }
}
