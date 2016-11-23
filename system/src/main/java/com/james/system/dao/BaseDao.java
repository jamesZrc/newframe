package com.james.system.dao;

import java.util.List;

/**
 * Created by eronzen on 11/23/2016.
 */
public interface BaseDao<T> {

    T get(Long id);

    List<T> getList();
}
