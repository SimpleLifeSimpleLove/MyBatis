package com.wxx.dao;

import com.wxx.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Date: 2020/11/10 19:37
 * Content:
 */
public interface UserMapper {

    @Select("select * from mybatis.user")
    List<User> getUsers();

    // 方法存在多个参数，所有的参数前必须加上 @Param() 注解，引用类型不用加
    /*
     @Param()
        基本类型的参数或者String类型，需要加上
        引用类型不需要加
        如果只有一个基本类型的话，可以忽略，但是建议大家都加上！
        我们在SQL中引用的就是我们这里的 @Param() 中设定的属性名
     */
    @Select("select * from mybatis.user where id = #{uid}")
    User getUserById(@Param("uid") int id);

    @Insert("insert into mybatis.user(id, name, pwd) values (#{id}, #{name}, #{password})")
    void addUser(User user);

    @Update("update mybatis.user set name=#{name},pwd=#{password} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from mybatis.user where id = #{uid}")
    void deleteUser(@Param("uid") int id);
}
