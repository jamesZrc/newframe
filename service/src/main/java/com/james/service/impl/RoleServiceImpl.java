package com.james.service.impl;


import com.james.model.RoleModel;
import com.james.model.UserModel;
import com.james.mybatis.dao.RoleDao;
import com.james.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eronzen on 11/24/2016.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleModel> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public List<RoleModel> getRolesByUser(UserModel user) {
        return roleDao.getRolesByUser(user);
    }

    @Override
    public RoleModel getRoleByRoleName(String roleName) {
        return roleDao.getRoleByRoleName(roleName);
    }
}
