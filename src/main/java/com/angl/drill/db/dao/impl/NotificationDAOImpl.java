package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.NotificationDAO;
import com.angl.drill.db.entity.NotificationEntity;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationDAOImpl extends BaseDao<NotificationEntity> implements NotificationDAO{

    public NotificationDAOImpl() {
        super(NotificationEntity.class);
    }
}
