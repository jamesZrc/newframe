package com.james.service;


import com.james.model.RoleModel;
import com.james.model.UserModel;

import java.util.List;

/**
 * Created by eronzen on 11/24/2016.
 */
public interface RoleService {

    List<RoleModel> getRoles();

    List<RoleModel> getRolesByUser(UserModel user);

    RoleModel getRoleByRoleName(String roleName);
}
