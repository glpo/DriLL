package com.angl.drill.services.impl;

import com.angl.drill.db.dao.ExperimentDAO;
import com.angl.drill.db.entity.Experiment;
import com.angl.drill.services.ExperimentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExperimentServiceImpl implements ExperimentService{

    @Autowired
    ExperimentDAO experimentDAO;

    public void add(Experiment entity) {
        experimentDAO.save(entity);
    }

    public void update(Experiment entity) {
        experimentDAO.save(entity);
    }

    public Experiment get(ObjectId id) {
        return experimentDAO.get(id);
    }

    public List<Experiment> getAll() {
        return experimentDAO.getAll();
    }

    public void remove(ObjectId id) {
        experimentDAO.remove(id);
    }
}
