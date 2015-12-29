package com.angl.drill.services;

import com.angl.drill.db.entity.ModalRoutingCardEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface ModalRoutingCardService {
    void add(ModalRoutingCardEntity entity);

    void update(ModalRoutingCardEntity entity);

    ModalRoutingCardEntity get(ObjectId id);

    List<ModalRoutingCardEntity> getAll();

    void remove(ObjectId id);
}
