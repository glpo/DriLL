package com.angl.drill.db.dao;

import com.angl.drill.db.entity.ConstantsEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface ConstantsDAO {

    void save(ConstantsEntity entity);

    ConstantsEntity get(ObjectId id);

    List<ConstantsEntity> getAll();

    void remove(ObjectId id);
}
