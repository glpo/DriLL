package com.angl.drill.db.dao;

import com.angl.drill.db.entity.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserDAO {

    void save(User entity);

    User get(ObjectId id);

    List<User> getAll();

    void remove(ObjectId id);
}
