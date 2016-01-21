package com.angl.drill.db.entity;

import java.util.Date;

public class Excavation {

    private Date time;
    private int exc;

    public Excavation() {
    }

    public Excavation(int excavation, Date time) {
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
