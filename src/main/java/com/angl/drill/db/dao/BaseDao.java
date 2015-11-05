package com.angl.drill.db.dao;


public abstract class BaseDao<T> {

    private Class<T> clazz;

    public abstract void save(T entity);
    public abstract <T> T get(String id);
    public abstract <T> T getAll();
    public abstract void remove(String id);

}
