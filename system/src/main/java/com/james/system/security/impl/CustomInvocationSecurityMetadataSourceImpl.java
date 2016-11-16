package com.james.system.security.impl;

import com.james.system.security.CustomInvocationSecurityMetadataSource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

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
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("ROLE_USER");
        atts.add(ca);
        resourceMap.put("/**", atts);
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String url = ((FilterInvocation) o).getRequestUrl();
        if("/".equals(url)){
            return null;
        }
        int firstQuestionMarkIndex = url.indexOf(".");
        if(firstQuestionMarkIndex != -1){
            url = url.substring(0,firstQuestionMarkIndex);
        }

        Iterator<String> ite = resourceMap.keySet().iterator();
        //取到请求的URL后与上面取出来的资源做比较
        while (ite.hasNext()) {
            String resURL = ite.next();
            if(this.pathMatchesUrl(url, resURL)){
                return resourceMap.get(resURL);
            }
        }
        return null;
    }

    private boolean pathMatchesUrl(String pattern, String target){
        return true;
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
