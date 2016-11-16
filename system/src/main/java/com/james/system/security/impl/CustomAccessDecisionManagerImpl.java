package com.james.system.security.impl;

import com.james.system.security.CustomAccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by eronzen on 11/15/2016.
 */
@Service("customAccessDecisionManager")
public class CustomAccessDecisionManagerImpl implements CustomAccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

        if (null == collection) {
            return;
        }

        Iterator<ConfigAttribute> cons = collection.iterator();

        while(cons.hasNext()){
            ConfigAttribute ca = cons.next();
            String needRole = ((SecurityConfig) ca).getAttribute();
            //gra 为用户所被赋予的权限，needRole为访问相应的资源应具有的权限
            for (GrantedAuthority gra : authentication.getAuthorities()) {
                if (needRole.trim().equals(gra.getAuthority().trim()) || "ROLE_ANONYMOUS".equals(gra.getAuthority().trim())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("Access Denied");


    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
