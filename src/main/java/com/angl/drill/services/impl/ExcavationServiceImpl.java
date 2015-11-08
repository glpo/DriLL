package com.angl.drill.services.impl;

import com.angl.drill.db.dao.ExcavationDAO;
import com.angl.drill.db.entity.ExcavationEntity;
import com.angl.drill.services.BaseService;
import com.angl.drill.services.ExcavationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcavationServiceImpl extends BaseService<ExcavationEntity> implements ExcavationService {
    @Autowired
    private ExcavationDAO excavationDAO;

    @Override
    public void add(ExcavationEntity entity) {
        excavationDAO.save(entity);
    }

    @Override
    public void update(ExcavationEntity entity) {
        excavationDAO.save(entity);
    }

    @Override
    public ExcavationEntity get(String id) {
        return excavationDAO.get(id);
    }

    @Override
    public List<ExcavationEntity> getAll() {
        return excavationDAO.getAll();
    }

    @Override
    public void remove(String id) {
        excavationDAO.remove(id);
    }
}
