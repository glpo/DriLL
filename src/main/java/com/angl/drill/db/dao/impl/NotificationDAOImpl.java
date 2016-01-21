package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.NotificationDAO;
import com.angl.drill.db.entity.Notification;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationDAOImpl extends BaseDao<Notification> implements NotificationDAO{

    public NotificationDAOImpl() {
        super(Notification.class);
    }
}
