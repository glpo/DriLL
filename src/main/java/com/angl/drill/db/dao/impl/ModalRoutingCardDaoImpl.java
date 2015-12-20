package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.ModalRoutingCardDAO;
import com.angl.drill.db.entity.ModalRoutingCardEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ModalRoutingCardDaoImpl  extends BaseDao<ModalRoutingCardEntity> implements ModalRoutingCardDAO {

    public ModalRoutingCardDaoImpl() {
        super(ModalRoutingCardEntity.class);
    }
}
