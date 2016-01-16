package com.angl.drill.services;

import com.angl.drill.db.entity.NotificationEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface NotificationService {
    void add(NotificationEntity entity);

    void update(NotificationEntity entity);

    NotificationEntity get(ObjectId id);

    List<NotificationEntity> getAll();

    void remove(ObjectId id);
}
