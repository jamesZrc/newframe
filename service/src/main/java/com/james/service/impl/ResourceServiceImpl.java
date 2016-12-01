package com.james.service.impl;


import com.james.model.ResourceModel;
import com.james.model.RoleModel;
import com.james.mybatis.dao.ResourceDao;
import com.james.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eronzen on 11/24/2016.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

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
