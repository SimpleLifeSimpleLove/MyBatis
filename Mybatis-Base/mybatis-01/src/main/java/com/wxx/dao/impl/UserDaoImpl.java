package com.wxx.dao.impl;

import com.wxx.dao.UserDao;
import com.wxx.pojo.User;

import java.util.List;

/**
 * Date: 2020/11/8 19:38
 * Content:
 */
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getList() {
        // 传统的方式是这里写 mysql 代码
        return null;
    }
}
