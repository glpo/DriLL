package com.angl.drill.services.impl;

import com.angl.drill.db.dao.ExcavationDAO;
import com.angl.drill.db.entity.ExcavationEntity;
import com.angl.drill.services.ExcavationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExcavationServiceImpl implements ExcavationService {
    @Autowired
    private ExcavationDAO excavationDAO;

    public void add(ExcavationEntity entity) {
        excavationDAO.save(entity);
    }

    public void update(ExcavationEntity entity) {
        excavationDAO.save(entity);
    }

    public ExcavationEntity get(String id) {
        return excavationDAO.get(id);
    }

    public List<ExcavationEntity> getAll() {
        return excavationDAO.getAll();
    }

    public void remove(String id) {
        excavationDAO.remove(id);
    }
}
