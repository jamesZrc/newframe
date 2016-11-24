package com.james.system.mapper;

import com.james.system.model.UserModel;

import java.util.List;

/**
 * Created by James on 2016/11/20.
 */
public interface UserMapper {

     List<UserModel> getUsers();

     UserModel getUserByUsername(String username);

}
