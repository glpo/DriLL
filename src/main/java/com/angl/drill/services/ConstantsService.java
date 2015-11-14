package com.angl.drill.services;

import com.angl.drill.db.entity.ConstantsEntity;

import java.util.List;

public interface ConstantsService {

    void add(ConstantsEntity entity);

    void update(ConstantsEntity entity);

    ConstantsEntity get(String id);

    List<ConstantsEntity> getAll();

    void remove(String id);
}
