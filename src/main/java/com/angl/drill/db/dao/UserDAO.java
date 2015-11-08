package com.angl.drill.db.dao;

import com.angl.drill.db.entity.UserEntity;

import java.util.List;

public interface UserDAO {

    void save(UserEntity entity);

    UserEntity get(String id);

    List<UserEntity> getAll();

    void remove(String id);
}
