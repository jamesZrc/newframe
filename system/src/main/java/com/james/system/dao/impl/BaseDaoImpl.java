package com.james.system.dao.impl;

import com.james.system.dao.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by eronzen on 11/23/2016.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Resource
    protected SqlSessionTemplate sqlSession;

    protected Class<T> clazz;

    public BaseDaoImpl(){
        //使用反射技术得到T的真实类型
        //获取当前new的对象的泛型的父类
        ParameterizedType pt =(ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个类型参数的真实类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public T get(Long id) {
        return null;
    }

    @Override
    public List<T> getList() {
        return sqlSession.selectList(clazz.getName());
    }

    protected String getSqlName(String sqlName) {
        String className = this.clazz.getName();
        return this.clazz.getName().concat(".").concat(sqlName);
    }
}
