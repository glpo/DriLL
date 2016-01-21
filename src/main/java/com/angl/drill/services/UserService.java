package com.angl.drill.services;

import com.angl.drill.db.entity.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {
    void add(User entity);

    void update(User entity);

    User get(ObjectId id);

    List<User> getAll();

    void remove(ObjectId id);
}
