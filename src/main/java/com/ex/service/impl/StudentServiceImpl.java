package com.ex.service.impl;

import com.ex.dao.StudentMapper;
import com.ex.model.Student;
import com.ex.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public boolean deleteByPrimaryKey(String studentId) {
        boolean flag = false;
        if(studentMapper.deleteByPrimaryKey(studentId)>0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public Student updateByPrimaryKeySelective(Integer studentId) {
        return null;

    }

    @Override
    public boolean updateByPrimaryKey(Student student) {
        boolean flag = false;
        int x;

        x=studentMapper.updateByPrimaryKey(student);
        System.out.println("x= ======================================="+x);
        if(x>0)
            flag = true;
        return flag;
    }

    @Override
    public Student selectByPrimaryKey(String studentId) {
        return null;
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> studentList = null;
        studentList = studentMapper.getStudentList();
        return studentList;
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentMapper.getStudentById(studentId);
    }
}
