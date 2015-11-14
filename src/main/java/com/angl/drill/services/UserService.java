package com.angl.drill.services;

import com.angl.drill.db.entity.UserEntity;

import java.util.List;

public interface UserService {
    void add(UserEntity entity);

    void update(UserEntity entity);

    UserEntity get(String id);

    List<UserEntity> getAll();

    void remove(String id);
}
