package com.angl.drill.services.impl;

import com.angl.drill.db.dao.ModalRoutingCardDAO;
import com.angl.drill.db.entity.ModalRoutingCardEntity;
import com.angl.drill.services.BaseService;
import com.angl.drill.services.ModalRoutingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModalRoutingCardServiceImpl extends BaseService<ModalRoutingCardEntity> implements ModalRoutingCardService{

    @Autowired
    ModalRoutingCardDAO modalRoutingCardDAO;

    @Override
    public void add(ModalRoutingCardEntity entity) {
        modalRoutingCardDAO.save(entity);
    }

    @Override
    public void update(ModalRoutingCardEntity entity) {
        modalRoutingCardDAO.save(entity);
    }

    public ModalRoutingCardEntity get(String id) {
        return modalRoutingCardDAO.get(id);
    }

    public List<ModalRoutingCardEntity> getAll() {
        return modalRoutingCardDAO.getAll();
    }

    @Override
    public void remove(String id) {
        modalRoutingCardDAO.remove(id);
    }
}
