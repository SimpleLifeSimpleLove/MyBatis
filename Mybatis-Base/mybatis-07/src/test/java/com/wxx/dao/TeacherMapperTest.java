package com.wxx.dao;

import com.wxx.pojo.Teacher;
import com.wxx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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

        // 第三步：关闭 SqlSession
        sqlSession.close();
    }

}
