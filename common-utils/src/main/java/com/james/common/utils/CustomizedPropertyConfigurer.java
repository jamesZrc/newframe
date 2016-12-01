package com.james.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * Created by eronzen on 11/30/2016.
 */
public class CustomizedPropertyConfigurer extends PropertyPlaceholderConfigurer {

    private static Properties properties;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)throws BeansException {
        super.processProperties(beanFactory, props);
        properties = props;
    }

    public static Properties getProperties(){
        return properties;
    }

}
