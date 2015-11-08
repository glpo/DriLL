package com.angl.drill.services.impl;

import com.angl.drill.db.dao.UserDAO;
import com.angl.drill.db.entity.UserEntity;
import com.angl.drill.services.BaseService;
import com.angl.drill.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseService<UserEntity> implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void add(UserEntity entity) {
        userDAO.save(entity);
    }

    @Override
    public void update(UserEntity entity) {
        userDAO.save(entity);
    }

    @Override
    public UserEntity get(String id) {
        return userDAO.get(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void remove(String id) {
        userDAO.remove(id);
    }
}
