package com.james.system.service;

import com.james.system.model.ResourceModel;
import com.james.system.model.RoleModel;

import java.util.List;

/**
 * Created by eronzen on 11/24/2016.
 */
public interface ResourceService {

    List<ResourceModel> getResources();

    List<ResourceModel> getResourcesByRole(RoleModel roleModel);

}
