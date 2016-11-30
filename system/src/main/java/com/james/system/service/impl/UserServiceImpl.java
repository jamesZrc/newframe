package com.james.system.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.james.system.dao.UserDao;
import com.james.system.model.RoleModel;
import com.james.system.model.UserModel;
import com.james.system.service.RoleService;
import com.james.system.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
