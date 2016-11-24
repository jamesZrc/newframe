package com.james.system.service.impl;

import com.james.system.mapper.UserMapper;
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
    private UserMapper userMapper;

    @Override
    public List<UserModel> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
