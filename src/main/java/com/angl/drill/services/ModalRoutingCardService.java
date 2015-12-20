package com.angl.drill.services;

import com.angl.drill.db.entity.ModalRoutingCardEntity;

import java.util.List;

public interface ModalRoutingCardService {
    void add(ModalRoutingCardEntity entity);

    void update(ModalRoutingCardEntity entity);

    ModalRoutingCardEntity get(String id);

    List<ModalRoutingCardEntity> getAll();

    void remove(String id);
}
