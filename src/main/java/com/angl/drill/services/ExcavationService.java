package com.angl.drill.services;

import com.angl.drill.db.entity.ExcavationSession;
import org.bson.types.ObjectId;

import java.util.List;

public interface ExcavationService {

    void add(ExcavationSession entity);

    void update(ExcavationSession entity);

    ExcavationSession get(ObjectId id);

    List<ExcavationSession> getAll();

    void remove(ObjectId id);


}
