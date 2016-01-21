package com.angl.drill.services;

import com.angl.drill.db.entity.Experiment;
import org.bson.types.ObjectId;

import java.util.List;

public interface ExperimentService {
    void add(Experiment entity);

    void update(Experiment entity);

    Experiment get(ObjectId id);

    List<Experiment> getAll();

    void remove(ObjectId id);
}
