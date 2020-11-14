package com.wxx.dao;

import com.wxx.pojo.User;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Date: 2020/11/14 21:41
 * Content:
 */
public class UserMapperTest {

    @Test
    public void testQueryUserById1() {

        /*
            一级缓存缓存失效的情况：
                (1) 查询不同的内容。(不能算吧......)
                (2) 增删改操作，可能会改变原来的数据，所以必定会刷新缓存。
                (3) 查询不同的Mapper.xml
                (4) 手动清理缓存
            一级缓存默认是开启的，只在一次sqlSession中有效，也就是拿到连接到关闭连接这个区间段!
            一级缓存就是一个map
         */

        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        sqlSession.clearCache();  // 手动清理缓存
        User user2 = mapper.queryUserById(1);
        System.out.println(user == user2);  // 未手动清理缓存：true, 手动清理缓存：false

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testQueryUserById2() {

        /*
            二级缓存
                只针对某个Mapper.xml有效
                所有的数据会先放在一级缓存中，只有当会话提交，或者关闭的时候，才会提交到二级缓存中!
            需要序列化pojo中的对象
         */

        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        // 第三步：关闭 SqlSession
        sqlSession.close();

        // 第二步：执行SQL.
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        // 第三步：关闭 SqlSession
        sqlSession.close();

        System.out.println(user == user2);  // 可能为false
    }
}
