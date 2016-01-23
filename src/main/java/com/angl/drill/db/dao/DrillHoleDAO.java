package com.angl.drill.db.dao;

import com.angl.drill.db.entity.DrillHole;
import org.bson.types.ObjectId;

import java.util.List;

public interface DrillHoleDAO {
    void save(DrillHole entity);

    DrillHole get(ObjectId id);

    List<DrillHole> getAll();

    void remove(ObjectId id);
}
