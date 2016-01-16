package com.angl.drill.db.dao;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class BaseDao<T> {
    @Autowired
    protected MongoOperations mongoOperations;

    private Class<T> clazz;

    public BaseDao(Class<T> entityClass) {
        this.clazz = entityClass;
    }

    public void save(T entity) {
        mongoOperations.save(entity);
    }

    public T get(ObjectId id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), clazz);
    }

    public List<T> getAll() {
        return mongoOperations.findAll(clazz);
    }

    public void remove(ObjectId id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), clazz);
    }
}
