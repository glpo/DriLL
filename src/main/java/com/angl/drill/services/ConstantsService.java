package com.angl.drill.services;

import com.angl.drill.db.entity.ConstantsEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface ConstantsService {

    void add(ConstantsEntity entity);

    void update(ConstantsEntity entity);

    ConstantsEntity get(ObjectId id);

    List<ConstantsEntity> getAll();

    void remove(ObjectId id);
}
