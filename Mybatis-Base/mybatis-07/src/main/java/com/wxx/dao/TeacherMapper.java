package com.wxx.dao;

import com.wxx.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Date: 2020/11/11 20:56
 * Content:
 */
public interface TeacherMapper {

    @Select("select * from mybatis.teacher where id = #{tid}")
    Teacher getTeacher(@Param("tid") int id);

}
