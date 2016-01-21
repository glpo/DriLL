package com.angl.drill.db.dao.impl;

import com.angl.drill.db.dao.BaseDao;
import com.angl.drill.db.dao.UserDAO;
import com.angl.drill.db.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDAO {

    public UserDaoImpl() {
        super(User.class);
    }
}
