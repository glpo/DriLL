package com.angl.drill.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = ConstantsEntity.COLLECTION_NAME)
public class ConstantsEntity {
    public static final String COLLECTION_NAME = "constants";

    @Id
    private String id;

    private String constantName;
    private Integer value;

    public ConstantsEntity() {}

    public ConstantsEntity(String constantName, Integer val) {
        this.constantName = constantName;
        this.value = val;
    }

    public String getConstantName() {
        return constantName;
    }

    public Integer getValue() {
        return value;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
