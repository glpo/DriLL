package com.angl.drill.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

public class ExcavationEntity {

    private Date time;
    private int exc;

    public ExcavationEntity() {
    }

    public ExcavationEntity(int excavation, Date time) {
        this.exc = excavation;
        this.time = time;
    }

    public int getExc() {
        return exc;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setExc(int exc) {
        this.exc = exc;
    }
}
