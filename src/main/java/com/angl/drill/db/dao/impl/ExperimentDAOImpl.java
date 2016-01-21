package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.ExperimentDAO;
import com.angl.drill.db.entity.Experiment;
import org.springframework.stereotype.Repository;

@Repository
public class ExperimentDAOImpl extends BaseDao<Experiment> implements ExperimentDAO {

    public ExperimentDAOImpl() {
        super(Experiment.class);
    }
}

