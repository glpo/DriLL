package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.ModalRoutingCardDAO;
import com.angl.drill.db.entity.ModalRoutingCard;
import org.springframework.stereotype.Repository;

@Repository
public class ModalRoutingCardDaoImpl  extends BaseDao<ModalRoutingCard> implements ModalRoutingCardDAO {

    public ModalRoutingCardDaoImpl() {
        super(ModalRoutingCard.class);
    }
}
