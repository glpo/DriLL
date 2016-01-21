package com.angl.drill.services;

import com.angl.drill.db.entity.Notification;
import org.bson.types.ObjectId;

import java.util.List;

public interface NotificationService {
    void add(Notification entity);

    void update(Notification entity);

    Notification get(ObjectId id);

    List<Notification> getAll();

    void remove(ObjectId id);
}
