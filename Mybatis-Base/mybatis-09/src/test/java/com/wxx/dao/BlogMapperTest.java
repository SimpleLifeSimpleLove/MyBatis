package com.wxx.dao;

import com.wxx.pojo.Blog;
import com.wxx.utils.IDUtils;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 2020/11/13 14:08
 * Content:
 */
public class BlogMapperTest {

    @Test
    public void testAddBlog() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog(IDUtils.getId(), "Mybatis如此简单", "kuang", new Date(), 9999);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testQueryBlogIF() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("title", "Java如此简单");
        map.put("author", "kuang");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testQueryBlogChoose() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "Java如此简单");
        map.put("author", "kuang");
        map.put("views", 9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdateBlog() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "3445210aec66454898ffc5a280e43270");
        map.put("title", "Mybatis如此简单2");
        map.put("author", "kuang");
//        map.put("views", 9999);
        mapper.updateBlog(map);

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }
}
