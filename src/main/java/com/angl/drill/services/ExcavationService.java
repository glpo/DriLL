package com.angl.drill.services;

import com.angl.drill.db.entity.ExcavationEntity;
import com.angl.drill.db.entity.ExcavationSessionEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface ExcavationService {

    void add(ExcavationSessionEntity entity);

    void update(ExcavationSessionEntity entity);

    ExcavationSessionEntity get(ObjectId id);

    List<ExcavationSessionEntity> getAll();

    void remove(ObjectId id);
}
