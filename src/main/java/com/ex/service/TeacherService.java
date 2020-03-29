package com.ex.service;


import com.ex.model.Teacher;

public interface TeacherService {



    boolean deleteByPrimaryKey(String teacherId);

    boolean insert(Teacher record);

    boolean insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String teacherId);

    Teacher getTeacherById(String teacherId);

    Teacher login(String teacherId, String teacherPwd);


    boolean updateByPrimaryKeySelective(Teacher record);

    boolean updateByPrimaryKey(Teacher teacher);//修改

    boolean updatePwd(String teacherId, String teacherPwd);
}
