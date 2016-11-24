package com.james.system.dao;

import com.james.system.model.RoleModel;
import com.james.system.model.UserModel;

import java.util.List;

/**
 * Created by eronzen on 11/24/2016.
 */
public interface RoleDao extends BaseDao {

    List<RoleModel> getRoles();

    List<RoleModel> getRolesByUser(UserModel user);

}
