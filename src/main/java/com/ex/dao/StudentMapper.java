package com.ex.dao;

import com.ex.model.Student;
import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);


    int deleteStudent(String studentId);

    Student getStudentById(String studentId);

    List<Student> getStudentList();

    List<Student> queryExcelInfo();

    public int delStudentById(String studentId);

    List<Student> selectId(String studentId);

    Student selectStudentExist(String studentId);

    Student selectEmailExist(String studentEmail);
}