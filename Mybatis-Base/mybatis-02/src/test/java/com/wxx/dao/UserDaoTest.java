package com.wxx.dao;

import com.wxx.pojo.User;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020/11/8 19:51
 * Content:
 * Test不能运行的问题：idea的原因!!! 不要用 idea2020.1!!!
 */
public class UserDaoTest {

    @Test
    public void testGetList() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL. 方式一 : getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        List<User> userList = mapper.getList();
//        userList.forEach(System.out::println);
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

    // 增删改需要提交事务
    @Test
    public void testAddUser() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        mapper.addUser(new User(4, "哈哈", "111111"));
        sqlSession.commit();  // 提交事务

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        mapper.updateUser(new User(4, "呵呵", "123321"));
        sqlSession.commit();  // 提交事务

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testDeleteUserById() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        mapper.deleteUserById(4);
        sqlSession.commit();  // 提交事务

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }


    /*
        万能的 map
     */
    @Test
    public void testAddUserUsingMap() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 5);
        map.put("userName", "zs");
        map.put("password", "234567");
        mapper.addUserUsingMap(map);
        sqlSession.commit();  // 提交事务

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    /*
        模糊查询
     */
    @Test
    public void testGetUserLike() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        /*
            '%a'     // 以a结尾的数据
            'a%'     // 以a开头的数据
            '%a%'    // 含有a的数据
            '_a_'    // 三位且中间字母是a的
            '_a'     // 两位且结尾字母是a的
            'a_'     // 两位且开头字母是a的
         */
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);  // mapper
//        List<User> userList = mapper.getUserLike("%李%");  // sql语句中不需要拼接 %
        List<User> userList = mapper.getUserLike("李");  // sql语句中需要拼接 %
        for (User user : userList) {
            System.out.println(user);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }
}
