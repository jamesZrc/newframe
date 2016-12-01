package com.james.service.impl;

import com.james.model.RoleModel;
import com.james.model.UserModel;
import com.james.mybatis.dao.UserDao;
import com.james.service.RoleService;
import com.james.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/11/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Value("${user.default.role}")
    private String defaultRole;

    @Autowired
    private RoleService roleService;

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
        RoleModel roleModel = roleService.getRoleByRoleName(defaultRole);

        UserModel model = this.getUserByUsername(userModel.getUsername());
        if(model != null){
            throw new IllegalArgumentException("user exist");
        }

        Map<String, Long> map = new HashMap<String, Long>();

        userDao.save(userModel);

        map.put("userId", userModel.getId());
        map.put("roleId", roleModel.getId());
        userDao.saveUserRole(map);
        return userModel;
    }
}
