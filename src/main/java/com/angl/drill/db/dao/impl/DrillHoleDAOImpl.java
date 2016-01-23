package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.DrillHoleDAO;
import com.angl.drill.db.entity.DrillHole;
import org.springframework.stereotype.Repository;

@Repository
public class DrillHoleDAOImpl extends BaseDao<DrillHole> implements DrillHoleDAO {

    public DrillHoleDAOImpl() {
        super(DrillHole.class);
    }
}
