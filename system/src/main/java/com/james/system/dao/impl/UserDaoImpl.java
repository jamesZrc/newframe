package com.james.system.dao.impl;

import com.james.system.dao.UserDao;
import com.james.system.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by James on 2016/11/20.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<UserModel> implements UserDao{

    @Override
    public List<UserModel> getUsers() {
        return sqlSession.selectList(super.getSqlName("getUsers"), UserModel.class);
    }
}
