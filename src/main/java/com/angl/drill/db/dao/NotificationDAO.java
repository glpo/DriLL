package com.angl.drill.db.dao;


import com.angl.drill.db.entity.NotificationEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface NotificationDAO {
    void save(NotificationEntity entity);

    NotificationEntity get(ObjectId id);

    List<NotificationEntity> getAll();

    void remove(ObjectId id);
}
