package com.ex.dao;

import com.ex.model.Teacher;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(String teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    int deleteTeacher(String teacherId);

    Teacher getTeacherById(String teacherId);

    List<Teacher> getTeacherList();

    List<Teacher> queryExcelInfo();

    public int delTeacherById(String teacherId);

    List<Teacher> selectId(String teacherId);
}