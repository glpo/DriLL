package com.angl.drill.db.dao;

import com.angl.drill.db.entity.ExcavationEntity;

import java.util.List;

public interface ExcavationDAO {

    void save(ExcavationEntity entity);

    ExcavationEntity get(String id);

    List<ExcavationEntity> getAll();

    void remove(String id);
}
