package com.angl.drill.db.dao;

import com.angl.drill.db.entity.UserEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserDAO {

    void save(UserEntity entity);

    UserEntity get(ObjectId id);

    List<UserEntity> getAll();

    void remove(ObjectId id);
}
