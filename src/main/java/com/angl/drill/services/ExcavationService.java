package com.angl.drill.services;

import com.angl.drill.db.entity.ExcavationEntity;

import java.util.List;

public interface ExcavationService {

    void add(ExcavationEntity entity);

    void update(ExcavationEntity entity);

    ExcavationEntity get(String id);

    List<ExcavationEntity> getAll();

    void remove(String id);
}
