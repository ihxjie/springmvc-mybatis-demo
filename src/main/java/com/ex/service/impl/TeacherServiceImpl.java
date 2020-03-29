package com.ex.service.impl;

import com.ex.dao.TeacherMapper;
import com.ex.model.Student;
import com.ex.model.Teacher;
import com.ex.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    TeacherMapper teacherMapper;
    @Resource
    TeacherMapper teachermapper;

    @Override
    public List<Teacher> getTeacherList() {
        List<Teacher> teacherList = null;
        teacherList = teacherMapper.getTeacherList();
        return teacherList;
    }

    @Override
    public boolean deleteTeacher(String teacherId) {
        boolean flag = false;
        if(teacherMapper.deleteTeacher(teacherId)>0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Teacher> queryExcelInfo() {
        return teacherMapper.queryExcelInfo();
    }

    @Override
    public boolean delTeacherById(String teacherId) {
        if(teacherMapper.delTeacherById(teacherId)>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Teacher> selectId(String teacherId) {
        List<Teacher> teacherList = null;
        teacherList = teacherMapper.selectId(teacherId);
        return teacherList;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Teacher record) {
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(Teacher teacher) {
        boolean flag = false;
        int x;

        x=teachermapper.updateByPrimaryKey(teacher);
        System.out.println("x= ======================================="+x);
        if(x>0)
            flag = true;
        return flag;
    }

    @Override
    public boolean updatePwd(String teacherId, String teacherPwd) {
        boolean flag = false;
        if(teachermapper.updatePwd(teacherId, teacherPwd) > 0)
            flag = true;
        return flag;
    }

    @Override
    public boolean insert(Teacher record) {
        boolean flag = false;
        if(teachermapper.insert(record) > 0)
            flag = true;
        return flag;
    }

    @Override
    public Teacher getTeacherById(String teacherId) {
        return teachermapper.getTeacherById(teacherId);
    }

}
