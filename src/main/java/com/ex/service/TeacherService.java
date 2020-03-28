package com.ex.service;

import com.ex.model.Student;
import com.ex.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeacherList();//获得全部教师信息

    boolean deleteTeacher(String teacherId);//删除教师信息

    Teacher getTeacherById(String teacherId);//查询id然后修改

    boolean updateByPrimaryKey(Teacher teacher);//修改教师信息

    List<Teacher> queryExcelInfo();//导出表格

    boolean insert(Teacher record);//增加教师信息
    boolean delTeacherById(String teacherId);//批量删除
    List<Teacher> selectId(String teacherId);//根据id查询教师信息后在本页面显示
}
