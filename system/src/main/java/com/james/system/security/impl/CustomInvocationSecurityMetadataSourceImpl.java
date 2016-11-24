package com.james.system.security.impl;

import com.james.system.model.ResourceModel;
import com.james.system.model.RoleModel;
import com.james.system.security.CustomInvocationSecurityMetadataSource;
import com.james.system.service.ResourceService;
import com.james.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by eronzen on 11/15/2016.
 */
@Service("customInvocationSecurityMetadataSource")
public class CustomInvocationSecurityMetadataSourceImpl implements CustomInvocationSecurityMetadataSource {

    private static final HashMap<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void init() {
        loadResourceDefine();
    }

    private void loadResourceDefine() {

        List<RoleModel> roles = roleService.getRoles();

        for (RoleModel role : roles) {
            List<ResourceModel> resources = resourceService.getResourcesByRole(role);
            for (ResourceModel resource : resources) {
                Collection<ConfigAttribute> configAttributes;
                if (resourceMap.containsKey(resource.getResource())) {
                    configAttributes = resourceMap.get(resource.getResource());
                } else {
                    configAttributes = new ArrayList<ConfigAttribute>();
                    resourceMap.put(resource.getResource(), configAttributes);
                }
                configAttributes.add(new SecurityConfig(role.getName()));
            }

        }

    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String url = ((FilterInvocation) o).getRequestUrl();
        int firstQuestionMarkIndex = url.indexOf(".");
        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }

        Iterator<String> ite = resourceMap.keySet().iterator();
        //取到请求的URL后与上面取出来的资源做比较
        PathMatcher pathMatcher = new AntPathMatcher();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (pathMatcher.match(resURL, url)) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
