package com.james.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;


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


    public static String getAccessIp() {

        String ip = Context.getHttpServletRequest().getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getHttpServletRequest().getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getHttpServletRequest().getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getHttpServletRequest().getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getHttpServletRequest().getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getHttpServletRequest().getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return ip;
    }

}
