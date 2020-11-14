package com.wxx.dao;

import com.wxx.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Date: 2020/11/14 21:36
 * Content:
 */
public interface UserMapper {

    // 根据 id 查询用户
    User queryUserById(@Param("id") int id);
}
