package com.angl.drill.services.impl;

import com.angl.drill.db.dao.ConstantsDAO;
import com.angl.drill.db.entity.ConstantsEntity;
import com.angl.drill.services.ConstantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConstantsServiceImpl implements ConstantsService {

    @Autowired
    private ConstantsDAO constantsDAO;

    public void add(ConstantsEntity entity) {
        constantsDAO.save(entity);
    }

    public void update(ConstantsEntity entity) {
        constantsDAO.save(entity);
    }

    public void remove(String id) {
        constantsDAO.remove(id);
    }

    public List<ConstantsEntity> getAll() {
        return constantsDAO.getAll();
    }

    public ConstantsEntity get(String id) {
        return constantsDAO.get(id);
    }
}
