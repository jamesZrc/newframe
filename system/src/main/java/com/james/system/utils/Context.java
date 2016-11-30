package com.james.system.utils;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by eronzen on 11/30/2016.
 */
public class Context {

    public static ServletRequestAttributes getServletRequestAttributes(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
    }

    public static HttpServletRequest getHttpServletRequest(){
        return getServletRequestAttributes().getRequest();
    }

    public static HttpServletResponse getHttpServletResponse(){
        return getServletRequestAttributes().getResponse();
    }

    public static HttpSession getHttpSession(){
        return getHttpServletRequest().getSession();
    }

    public static ServletContext getServletContext(){
        return  getHttpSession().getServletContext();
    }

    public static ApplicationContext getApplicationContext(){
       return WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }

    public static Object getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }

    public static <T>T getBean(String beanName , Class<T>clazz) {
        return getApplicationContext().getBean(beanName , clazz);
    }

    public static SecurityContext getSecurityContext(){
        return SecurityContextHolder.getContext();
    }

    public static Object getCurrentUser(){
        return getSecurityContext().getAuthentication().getPrincipal();
    }

}
