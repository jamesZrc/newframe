package com.james.system.dao.impl;

import com.james.system.dao.UserDao;
import com.james.system.model.UserModel;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by James on 2016/11/20.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SqlSessionTemplate sqlSession;

    @Override
    public List<UserModel> getUsers() {
        return sqlSession.selectList("com.james.system.dao.UserDao.getUsers", UserModel.class);
    }
}
