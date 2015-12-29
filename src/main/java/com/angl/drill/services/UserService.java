package com.angl.drill.services;

import com.angl.drill.db.entity.UserEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {
    void add(UserEntity entity);

    void update(UserEntity entity);

    UserEntity get(ObjectId id);

    List<UserEntity> getAll();

    void remove(ObjectId id);
}
