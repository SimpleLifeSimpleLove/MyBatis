package com.wxx.dao;

import com.wxx.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Date: 2020/11/10 19:37
 * Content:
 */
public interface UserMapper {

    // 根据 id 查询用户
    User getUserById(int id);
}
