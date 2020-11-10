package com.wxx.dao;

import com.wxx.pojo.User;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Date: 2020/11/10 20:00
 * Content:
 * Test不能运行的问题：idea的原因!!! 不要用 idea2020.1!!!
 */
public class UserDaoTest {

    @Test
    public void testGetUser() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        // 底层用的是反射。(框架 = 注解 + 反射 + 设计模式)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        List<User> userList = mapper.getUsers();
        for (User user : userList) {
            System.out.println(user);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        User user = mapper.getUserById(1);
        System.out.println(user);

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        // 底层用的是反射。(框架 = 注解 + 反射 + 设计模式)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        mapper.addUser(new User(4, "李四", "123789"));

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        // 底层用的是反射。(框架 = 注解 + 反射 + 设计模式)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        mapper.updateUser(new User(5, "王五", "123789"));

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        // 底层用的是反射。(框架 = 注解 + 反射 + 设计模式)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        mapper.deleteUser(5);

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }
}
