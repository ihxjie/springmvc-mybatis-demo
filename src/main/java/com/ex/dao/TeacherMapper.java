package com.ex.dao;

import com.ex.model.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(String teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher getTeacherById(String teacherId);

    int updatePwd(String teacherId, String teacherPwd);

    Teacher getLoginTeacher(String teacherId);

}