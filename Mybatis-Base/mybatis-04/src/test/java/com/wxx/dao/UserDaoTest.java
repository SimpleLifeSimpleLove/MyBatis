package com.wxx.dao;

import com.wxx.pojo.User;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Date: 2020/11/10 19:51
 * Content:
 * Test不能运行的问题：idea的原因!!! 不要用 idea2020.1!!!
 */
public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

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
    public void testLog4j() {

        logger.info("info : 进入了testLog4j()");
        logger.debug("debug : 进入了testLog4j()");
        logger.error("error : 进入了testLog4j()");
        /*
            输出到控制台和文件中的信息：
                [com.wxx.dao.UserDaoTest]-info : 进入了testLog4j()
                [com.wxx.dao.UserDaoTest]-debug : 进入了testLog4j()
                [com.wxx.dao.UserDaoTest]-error : 进入了testLog4j()
         */
    }
}
