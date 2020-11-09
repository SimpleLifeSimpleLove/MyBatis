package com.wxx.dao;

import com.wxx.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Date: 2020/11/8 19:37
 * Content:
 */
public interface UserMapper {

    // 查询全部用户
    List<User> getList();

    // 根据 id 查询用户
    User getUserById(int id);

    // 插入一个用户
    void addUser(User user);

    // 修改用户
    void updateUser(User user);

    // 删除一个用户
    void deleteUserById(int id);

    /*
        万能的 map
     */
    void addUserUsingMap(Map<String, Object> map);

    /*
        模糊查询
     */
    List<User> getUserLike(String value);
}
