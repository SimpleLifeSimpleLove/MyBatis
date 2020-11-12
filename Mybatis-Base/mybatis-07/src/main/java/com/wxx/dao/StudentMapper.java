package com.wxx.dao;

import com.wxx.pojo.Student;

import java.util.List;

/**
 * Date: 2020/11/11 20:56
 * Content:
 */
public interface StudentMapper {

    // 查询所有的学生信息，以及对应的老师信息
    public List<Student> getStudent();
    public List<Student> getStudent2();  // 常用
}
