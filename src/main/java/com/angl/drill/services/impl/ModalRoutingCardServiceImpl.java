package com.angl.drill.services.impl;

import com.angl.drill.db.dao.ModalRoutingCardDAO;
import com.angl.drill.db.entity.ModalRoutingCard;
import com.angl.drill.services.BaseService;
import com.angl.drill.services.ModalRoutingCardService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModalRoutingCardServiceImpl extends BaseService<ModalRoutingCard> implements ModalRoutingCardService{

    @Autowired
    ModalRoutingCardDAO modalRoutingCardDAO;

    @Override
    public void add(ModalRoutingCard entity) {
        modalRoutingCardDAO.save(entity);
    }

    @Override
    public void update(ModalRoutingCard entity) {
        modalRoutingCardDAO.save(entity);
    }

    public ModalRoutingCard get(ObjectId id) {
        return modalRoutingCardDAO.get(id);
    }

    public List<ModalRoutingCard> getAll() {
        return modalRoutingCardDAO.getAll();
    }

    @Override
    public void remove(ObjectId id) {
        modalRoutingCardDAO.remove(id);
    }
}
