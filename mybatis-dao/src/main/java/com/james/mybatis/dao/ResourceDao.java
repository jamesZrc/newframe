package com.james.mybatis.dao;



import com.james.model.ResourceModel;
import com.james.model.RoleModel;

import java.util.List;

/**
 * Created by eronzen on 11/24/2016.
 */
public interface ResourceDao {

    List<ResourceModel> getResources();

    List<ResourceModel> getResourcesByRole(RoleModel roleModel);

}
