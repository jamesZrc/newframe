package com.james.system.common;

import com.james.system.utils.Conf;
import com.james.system.utils.RedisUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eronzen on 12/1/2016.
 */
public class MethodCacheInterceptor implements MethodInterceptor {
    private RedisUtil redisUtil;
    private List<String> targetNamesList; // 不加入缓存的service名称
    private List<String> methodNamesList; // 不加入缓存的方法名称
    private Long defaultCacheExpireTime; // 缓存默认的过期时间

    public MethodCacheInterceptor() {
        try {
            targetNamesList = Arrays.asList(Conf.get("targetNames").split(","));
            methodNamesList = Arrays.asList(Conf.get("methodNames").split(","));
            // 加载过期时间设置
            defaultCacheExpireTime = Long.valueOf(Conf.get("defaultCacheExpireTime"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object value = null;

        String targetName = invocation.getThis().getClass().getName();
        String methodName = invocation.getMethod().getName();
        // 不需要缓存的内容
        if (!isAddCache(targetName, methodName)) {
            // 执行方法返回结果
            return invocation.proceed();
        }
        Object[] arguments = invocation.getArguments();
        String key = getCacheKey(targetName, methodName, arguments);

        try {
            if (redisUtil.exists(key)) {
                return redisUtil.get(key);
            }
            value = invocation.proceed();
            if (value != null) {
                final String tkey = key;
                final Object tvalue = value;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        redisUtil.set(tkey, tvalue, defaultCacheExpireTime);
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (value == null) {
                return invocation.proceed();
            }
        }
        return value;
    }

    /**
     * 是否加入缓存
     *
     * @return
     */
    private boolean isAddCache(String targetName, String methodName) {
        boolean flag = true;
        if (targetNamesList.contains(targetName) || methodNamesList.contains(methodName)) {
            flag = false;
        }
        return flag;
    }

    /**
     * 创建缓存key
     *
     * @param targetName
     * @param methodName
     * @param arguments
     */
    private String getCacheKey(String targetName, String methodName, Object[] arguments) {
        StringBuffer sbu = new StringBuffer();
        sbu.append(targetName).append("_").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sbu.append("_").append(arguments[i]);
            }
        }
        return sbu.toString();
    }

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }
}
