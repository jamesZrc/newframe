package com.james.mybatis.dao;

import com.james.model.UserModel;

import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/11/20.
 */
public interface UserDao extends  BaseDao{

     List<UserModel> getUsers();

     UserModel getUserByUsername(String username);

     void save(UserModel userModel);

     void saveUserRole(Map<String, Long> map);

}
