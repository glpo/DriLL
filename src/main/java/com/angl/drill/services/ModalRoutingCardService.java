package com.angl.drill.services;

import com.angl.drill.db.entity.ModalRoutingCard;
import org.bson.types.ObjectId;

import java.util.List;

public interface ModalRoutingCardService {
    void add(ModalRoutingCard entity);

    void update(ModalRoutingCard entity);

    ModalRoutingCard get(ObjectId id);

    List<ModalRoutingCard> getAll();

    void remove(ObjectId id);
}
