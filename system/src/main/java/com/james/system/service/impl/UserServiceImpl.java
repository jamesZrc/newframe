package com.james.system.service.impl;

import com.james.system.dao.UserDao;
import com.james.system.model.UserModel;
import com.james.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by James on 2016/11/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserModel> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public UserModel save(UserModel userModel) {
        userDao.save(userModel);
        return userModel;
    }
}
