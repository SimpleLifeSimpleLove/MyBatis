package com.wxx.dao;

import com.wxx.pojo.User;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020/11/10 20:00
 * Content:
 * Test不能运行的问题：idea的原因!!! 不要用 idea2020.1!!!
 */
public class UserDaoTest {

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
    public void testGetUserByLimit() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserByRowBounds() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL. 通过Java代码层面实现分页
        RowBounds rowBounds = new RowBounds(1, 2);
        List<User> userList = sqlSession.selectList("com.wxx.dao.UserMapper.getUserByRowBounds", 0, rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }
}
