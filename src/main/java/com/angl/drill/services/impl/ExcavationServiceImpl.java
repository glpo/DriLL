package com.angl.drill.services.impl;

import com.angl.drill.db.dao.ExcavationDAO;
import com.angl.drill.db.entity.ExcavationSession;
import com.angl.drill.services.ExcavationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExcavationServiceImpl implements ExcavationService {
    @Autowired
    private ExcavationDAO excavationDAO;

    public void add(ExcavationSession entity) {
        excavationDAO.save(entity);
    }

    public void update(ExcavationSession entity) {
        excavationDAO.save(entity);
    }

    public ExcavationSession get(ObjectId id) {
        return excavationDAO.get(id);
    }

    public List<ExcavationSession> getAll() {
        return excavationDAO.getAll();
    }

    public void remove(ObjectId id) {
        excavationDAO.remove(id);
    }
}
