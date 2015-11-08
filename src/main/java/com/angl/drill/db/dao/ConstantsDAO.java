package com.angl.drill.db.dao;

import com.angl.drill.db.entity.ConstantsEntity;

import java.util.List;

public interface ConstantsDAO {

    void save(ConstantsEntity entity);

    ConstantsEntity get(String id);

    List<ConstantsEntity> getAll();

    void remove(String id);
}
