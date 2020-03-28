package com.ex.dao;

import com.ex.model.Student;
import com.ex.model.Teacher;

import java.util.List;

public interface TeacherMapper {
    int deleteTeacher(String teacherId);

    int insert(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher getTeacherById(String teacherId);

    List<Teacher> getTeacherList();

    List<Teacher> queryExcelInfo();

    public int delTeacherById(String teacherId);

    List<Teacher> selectId(String teacherId);
}