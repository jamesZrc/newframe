package com.james.system.security.impl;

import com.james.system.security.CustomInvocationSecurityMetadataSource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by eronzen on 11/15/2016.
 */
@Service("customInvocationSecurityMetadataSource")
public class CustomInvocationSecurityMetadataSourceImpl implements CustomInvocationSecurityMetadataSource {

    private static final HashMap<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

    @PostConstruct
    public void init() {
        loadResourceDefine();
    }

    private void loadResourceDefine() {
        Collection<ConfigAttribute> roleAdminAtts = new ArrayList<ConfigAttribute>();
        ConfigAttribute roleAdmin = new SecurityConfig("ROLE_ADMIN");
        roleAdminAtts.add(roleAdmin);
        resourceMap.put("/rest/**", roleAdminAtts);

        Collection<ConfigAttribute> roleUserAtts = new ArrayList<ConfigAttribute>();
        ConfigAttribute roleUser = new SecurityConfig("ROLE_USER");
        roleUserAtts.add(roleUser);
        roleUserAtts.add(roleAdmin);
        resourceMap.put("/", roleUserAtts);
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
