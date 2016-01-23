package com.angl.drill.services;

import com.angl.drill.db.entity.DrillHole;
import org.bson.types.ObjectId;

import java.util.List;

public interface DrillHoleService {
    void add(DrillHole entity);

    void update(DrillHole entity);

    DrillHole get(ObjectId id);

    List<DrillHole> getAll();

    void remove(ObjectId id);
}
