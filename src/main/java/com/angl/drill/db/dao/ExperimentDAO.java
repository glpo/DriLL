package com.angl.drill.db.dao;

import com.angl.drill.db.entity.Experiment;
import org.bson.types.ObjectId;

import java.util.List;

public interface ExperimentDAO {
    void save(Experiment entity);

    Experiment get(ObjectId id);

    List<Experiment> getAll();

    void remove(ObjectId id);
}
