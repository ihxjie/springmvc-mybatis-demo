package com.ex.dao;

import com.ex.model.Student;

import java.util.List;

public interface StudentMapper {
    int deleteStudent(String studentId);

    int insert(Student record);

    int updateByPrimaryKey(Student record);

    Student getStudentById(String studentId);

    List<Student> getStudentList();
    List<Student> queryExcelInfo();

    public int delStudentById(String studentId);

    List<Student> selectId(String studentId);

    Student selectStudentExist(String studentId);

    Student selectEmailExist(String studentEmail);
}