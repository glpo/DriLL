package com.angl.drill.db.dao;

import com.angl.drill.db.entity.ExcavationEntity;
import com.angl.drill.db.entity.ExcavationSessionEntity;
import com.angl.drill.services.ExcavationService;
import org.bson.types.ObjectId;

import java.util.List;

public interface ExcavationDAO {

    void save(ExcavationSessionEntity entity);

    ExcavationSessionEntity get(ObjectId id);

    List<ExcavationSessionEntity> getAll();

    void remove(ObjectId id);
}
