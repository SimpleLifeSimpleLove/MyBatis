package com.wxx.dao;

import com.wxx.pojo.User;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
        UserDao userDao = sqlSession.getMapper(UserDao.class);  // mapper
        List<User> userList = userDao.getList();
//        userList.forEach(System.out::println);
        for (User user : userList) {
            System.out.println(user);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }
}
