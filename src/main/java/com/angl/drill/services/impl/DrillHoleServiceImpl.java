package com.angl.drill.services.impl;

import com.angl.drill.db.dao.DrillHoleDAO;
import com.angl.drill.db.entity.DrillHole;
import com.angl.drill.services.DrillHoleService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DrillHoleServiceImpl implements DrillHoleService{

    @Autowired
    private DrillHoleDAO drillHoleDAO;

    public void add(DrillHole entity) {
        drillHoleDAO.save(entity);
    }

    public void update(DrillHole entity) {
        drillHoleDAO.save(entity);
    }

    public DrillHole get(ObjectId id) {
        return drillHoleDAO.get(id);
    }

    public List<DrillHole> getAll() {
        return drillHoleDAO.getAll();
    }

    public void remove(ObjectId id) {
        drillHoleDAO.remove(id);
    }
}
