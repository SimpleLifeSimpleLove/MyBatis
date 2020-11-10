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

    // 分页：通过 limit 实现
    List<User> getUserByLimit(Map<String, Integer> map);

    // 分页：通过 RowBounds 实现 (不实用)
    List<User> getUserByRowBounds(Map<String, Integer> map);
}
