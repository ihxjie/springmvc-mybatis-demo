package com.ex.service;

import com.ex.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();//获取全部学生信息

    boolean deleteStudent(String studentId);//根据id删除学生信息

    Student getStudentById(String studentId);//根据id查看信息

    boolean updateByPrimaryKey(Student student);//修改

    List<Student> queryExcelInfo();//导出表格

    boolean insert(Student record);//插入

    boolean delStudentById(String studentId);//批量删除

    List<Student> selectId(String studentId);//根据id查询在本页面显示

    Student selectStudentExist(String studentId);//验证学生账号

    Student selectEmailExist(String studentEmail);//验证学生邮箱



    //Student getStudentById(int studentId);
}
