package com.james.common.utils;


import java.util.Properties;

/**
 * Created by eronzen on 11/30/2016.
 */
public class Conf {

    public static Properties getProperties(){
        return CustomizedPropertyConfigurer.getProperties();
    }

    public static String get(String key){
        return (String) getProperties().get(key);
    }

    public static boolean containsKey(String key){
        return  getProperties().containsKey(key);
    }

    public static boolean containsValue(String value){
        return  getProperties().containsValue(value);
    }
}
