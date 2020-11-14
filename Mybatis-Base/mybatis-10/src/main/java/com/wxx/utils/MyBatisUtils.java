package com.wxx.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Date: 2020/11/10 19:20
 * Content: sqlSessionFactory --> sqlSession
 */
public class MyBatisUtils {
    /*
        SqlSessionFactoryBuilder :
            一旦创建了 SqlSessionFactory，就不再需要它了
            局部变量
        SqlSessionFactory :
            说白了就是可以想象为 ：数据库连接池
            SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。
            因此 SqlSessionFactory 的最佳作用域是应用作用域。
            最简单的就是使用单例模式或者静态单例模式。
        SqlSession :
            连接到连接池的一个请求！
            SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。
            用完之后需要赶紧关闭，否则资源被占用！
     */

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true);  // 设置事务自动提交
    }
}
