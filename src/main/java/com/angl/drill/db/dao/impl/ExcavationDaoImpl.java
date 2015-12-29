package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.ExcavationDAO;
import com.angl.drill.db.entity.ExcavationEntity;
import com.angl.drill.db.entity.ExcavationSessionEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ExcavationDaoImpl extends BaseDao<ExcavationSessionEntity> implements ExcavationDAO {

    public ExcavationDaoImpl() {
        super(ExcavationSessionEntity.class);
    }
}
