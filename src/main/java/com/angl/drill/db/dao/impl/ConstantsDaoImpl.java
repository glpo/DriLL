package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.ConstantsDAO;
import com.angl.drill.db.entity.ConstantsEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ConstantsDaoImpl extends BaseDao<ConstantsEntity> implements ConstantsDAO {

    public ConstantsDaoImpl() {
        super(ConstantsEntity.class);
    }
}
