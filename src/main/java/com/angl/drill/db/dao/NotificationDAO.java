package com.angl.drill.db.dao;


import com.angl.drill.db.entity.Notification;
import org.bson.types.ObjectId;

import java.util.List;

public interface NotificationDAO {
    void save(Notification entity);

    Notification get(ObjectId id);

    List<Notification> getAll();

    void remove(ObjectId id);
}
