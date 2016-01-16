package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.ExcavationDAO;
import com.angl.drill.db.entity.ExcavationEntity;
import com.angl.drill.db.entity.ExcavationSessionEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExcavationDaoImpl extends BaseDao<ExcavationSessionEntity> implements ExcavationDAO {

    public ExcavationDaoImpl() {
        super(ExcavationSessionEntity.class);
    }

    public int getMaxSessionNumber() {
        Query maxSessionNumber = new Query();
        maxSessionNumber.with(new Sort(Sort.Direction.DESC, "session"));
        maxSessionNumber = maxSessionNumber.limit(1);
        ExcavationSessionEntity excavationSession = mongoOperations.findOne(maxSessionNumber, ExcavationSessionEntity.class);
        if(excavationSession != null) {
            return excavationSession.getSessionNumber();
        }

        return 0;
    }
}
