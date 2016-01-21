package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.ExcavationDAO;
import com.angl.drill.db.entity.ExcavationSession;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ExcavationDaoImpl extends BaseDao<ExcavationSession> implements ExcavationDAO {

    public ExcavationDaoImpl() {
        super(ExcavationSession.class);
    }

    public int getMaxSessionNumber() {
        Query maxSessionNumber = new Query();
        maxSessionNumber.with(new Sort(Sort.Direction.DESC, "session"));
        maxSessionNumber = maxSessionNumber.limit(1);
        ExcavationSession excavationSession = mongoOperations.findOne(maxSessionNumber, ExcavationSession.class);
        if(excavationSession != null) {
            return excavationSession.getSessionNumber();
        }

        return 0;
    }
}
