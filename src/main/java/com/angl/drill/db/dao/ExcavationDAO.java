package com.angl.drill.db.dao;

import com.angl.drill.db.entity.ExcavationSession;
import org.bson.types.ObjectId;

import java.util.List;

public interface ExcavationDAO {

    void save(ExcavationSession entity);

    ExcavationSession get(ObjectId id);

    List<ExcavationSession> getAll();

    void remove(ObjectId id);

    int getMaxSessionNumber();
}
