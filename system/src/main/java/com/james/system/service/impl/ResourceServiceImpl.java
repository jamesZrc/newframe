package com.james.system.service.impl;

import com.james.system.dao.ResourceDao;
import com.james.system.model.ResourceModel;
import com.james.system.model.RoleModel;
import com.james.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eronzen on 11/24/2016.
 */
@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<ResourceModel> getResources() {
        return resourceDao.getResources();
    }

    @Override
    public List<ResourceModel> getResourcesByRole(RoleModel roleModel) {
        return resourceDao.getResourcesByRole(roleModel);
    }
}
