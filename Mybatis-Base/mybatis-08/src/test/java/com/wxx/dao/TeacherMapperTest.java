package com.wxx.dao;

import com.wxx.pojo.Teacher;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Date: 2020/11/11 20:59
 * Content:
 */
public class TeacherMapperTest {

    @Test
    public void testGetTeacher() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        /*
            Teacher(
                id=1,
                name=秦老师,
                students=[
                    Student(id=1, name=小明, tid=1),
                    Student(id=2, name=小红, tid=1),
                    Student(id=3, name=小张, tid=1),
                    Student(id=4, name=小李, tid=1),
                    Student(id=5, name=小王, tid=1)
                ]
            )
         */

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetTeacher2() {
        // 第一步：获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 第二步：执行SQL.
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);
        /*
            Teacher(
                id=1,
                name=秦老师,
                students=[
                    Student(id=1, name=小明, tid=1),
                    Student(id=2, name=小红, tid=1),
                    Student(id=3, name=小张, tid=1),
                    Student(id=4, name=小李, tid=1),
                    Student(id=5, name=小王, tid=1)
                ]
            )
         */

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

}
