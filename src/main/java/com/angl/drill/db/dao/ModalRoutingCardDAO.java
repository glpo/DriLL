package com.angl.drill.db.dao;

import com.angl.drill.db.entity.ModalRoutingCard;
import org.bson.types.ObjectId;

import java.util.List;

public interface ModalRoutingCardDAO {

    void save(ModalRoutingCard entity);

    ModalRoutingCard get(ObjectId id);

    List<ModalRoutingCard> getAll();

    void remove(ObjectId id);
}
