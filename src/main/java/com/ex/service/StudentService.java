package com.ex.service;

import com.ex.model.Student;

import java.util.List;

public interface StudentService {

    boolean deleteByPrimaryKey(String studentId);//根据id删除学生信息

    Student updateByPrimaryKeySelective(Integer studentId);

    boolean updateByPrimaryKey(Student student);//修改

    Student selectByPrimaryKey(String studentId);

    List<Student> getStudentList();//获取全部学生信息

    Student getStudentById(String studentId);
}
