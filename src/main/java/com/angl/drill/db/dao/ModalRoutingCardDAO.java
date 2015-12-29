package com.angl.drill.db.dao;

import com.angl.drill.db.entity.ModalRoutingCardEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface ModalRoutingCardDAO {

    void save(ModalRoutingCardEntity entity);

    ModalRoutingCardEntity get(ObjectId id);

    List<ModalRoutingCardEntity> getAll();

    void remove(ObjectId id);
}
