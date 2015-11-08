package com.angl.drill.services.impl;

import com.angl.drill.db.dao.ConstantsDAO;
import com.angl.drill.db.entity.ConstantsEntity;
import com.angl.drill.services.BaseService;
import com.angl.drill.services.ConstantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConstantsServiceImpl extends BaseService<ConstantsEntity> implements ConstantsService {

    @Autowired
    private ConstantsDAO constantsDAO;

    @Override
    public void add(ConstantsEntity entity) {
        constantsDAO.save(entity);
    }

    @Override
    public void update(ConstantsEntity entity) {
        constantsDAO.save(entity);
    }

    @Override
    public void remove(String id) {
        constantsDAO.remove(id);
    }

    @Override
    public List<ConstantsEntity> getAll() {
        return constantsDAO.getAll();
    }

    @Override
    public ConstantsEntity get(String id) {
        return constantsDAO.get(id);
    }
}
