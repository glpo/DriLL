package com.angl.drill.services;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class BaseService<T> {
    private Class<T> clazz;

    public abstract void add(T entity);

    public abstract void update(T entity);

    public abstract <T> T get(ObjectId id);

    public abstract <T> List<T> getAll();

    public abstract void remove(ObjectId id);
}
