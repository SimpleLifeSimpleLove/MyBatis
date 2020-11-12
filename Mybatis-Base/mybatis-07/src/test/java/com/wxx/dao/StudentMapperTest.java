package com.wxx.dao;

import com.wxx.pojo.Student;
import com.wxx.pojo.Teacher;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Date: 2020/11/12 16:33
 * Content:
 */
public class StudentMapperTest {

    @Test
    public void testGetStudent() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetStudent2() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

}
