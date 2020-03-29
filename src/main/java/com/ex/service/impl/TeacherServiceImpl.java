package com.ex.service.impl;

import com.ex.dao.TeacherMapper;
import com.ex.model.Teacher;
import com.ex.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    TeacherMapper teachermapper;


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
    public boolean deleteByPrimaryKey(String teacherId) {
        boolean flag = true;
        if(teachermapper.deleteByPrimaryKey(teacherId) < 1)
            flag = false;
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
    public boolean insertSelective(Teacher record) {
        return false;
    }

    @Override
    public Teacher selectByPrimaryKey(String teacherId) {
        return null;
    }

    @Override
    public Teacher getTeacherById(String teacherId) {
        return teachermapper.getTeacherById(teacherId);
    }

    @Override
    public Teacher login(String teacherId, String teacherPwd) {
        Teacher teacher = null;
        teacher = teachermapper.getLoginTeacher(teacherId);
        //匹配密码
        if(null != teacher){
            if(!teacher.getTeacherPwd().equals(teacherPwd))
                teacher = null;
        }
        return teacher;
    }
}
