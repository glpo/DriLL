package com.angl.drill.services.impl;

import com.angl.drill.db.dao.NotificationDAO;
import com.angl.drill.db.entity.NotificationEntity;
import com.angl.drill.services.BaseService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotificationServiceImpl extends BaseService<NotificationEntity> implements NotificationDAO{
    @Autowired
    NotificationDAO notificationDAO;

    @Override
    public void add(NotificationEntity entity) {
        notificationDAO.save(entity);
    }

    @Override
    public void update(NotificationEntity entity) {
        notificationDAO.save(entity);
    }

    public void save(NotificationEntity entity) {  notificationDAO.save(entity);  }

    public NotificationEntity get(ObjectId id) {
        return notificationDAO.get(id);
    }

    public List<NotificationEntity> getAll() {
        return notificationDAO.getAll();
    }

    @Override
    public void remove(ObjectId id) {
        notificationDAO.remove(id);
    }
}
