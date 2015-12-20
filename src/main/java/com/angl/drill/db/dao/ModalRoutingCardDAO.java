package com.angl.drill.db.dao;

import com.angl.drill.db.entity.ModalRoutingCardEntity;

import java.util.List;

public interface ModalRoutingCardDAO {

    void save(ModalRoutingCardEntity entity);

    ModalRoutingCardEntity get(String id);

    List<ModalRoutingCardEntity> getAll();

    void remove(String id);
}
