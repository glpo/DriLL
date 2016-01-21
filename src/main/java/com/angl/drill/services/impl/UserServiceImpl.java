package com.angl.drill.services.impl;

import com.angl.drill.db.dao.UserDAO;
import com.angl.drill.db.entity.User;
import com.angl.drill.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void add(User entity) {
        userDAO.save(entity);
    }

    public void update(User entity) {
        userDAO.save(entity);
    }

    public User get(ObjectId id) {
        return userDAO.get(id);
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public void remove(ObjectId id) {
        userDAO.remove(id);
    }
}
