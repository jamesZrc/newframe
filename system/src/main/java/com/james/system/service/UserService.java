package com.james.system.service;

import com.james.system.model.UserModel;

import java.util.List;

/**
 * Created by James on 2016/11/20.
 */
public interface UserService {

    List<UserModel> getUsers();

    UserModel getUserByUsername(String username);

    UserModel save(UserModel userModel);

}
