package com.james.system.dao;

import com.james.system.model.UserModel;

import java.util.List;

/**
 * Created by James on 2016/11/20.
 */
public interface UserDao extends  BaseDao<UserModel>{

     List<UserModel> getUsers();

     UserModel getUserByUsername(String username);

}
