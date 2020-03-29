package com.ex.service.impl;

import com.ex.dao.ResultMapper;
import com.ex.model.Result;
import com.ex.service.ResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    ResultMapper resultMapper;

    @Resource
    ResultService resultService;

    @Override
    public boolean deleteByPrimaryKey(Integer resultId) {
        boolean flag = true;
        if(resultMapper.deleteByPrimaryKey(resultId) < 1)
            flag = false;
        return flag;
    }

    @Override
    public boolean insert(Result record) {
        boolean flag = false;
        if(resultMapper.insert(record) > 0)
            flag = true;
        return flag;
    }

    @Override
    public boolean insertSelective(Result record) {
        return false;
    }

    @Override
    public Result selectByPrimaryKey(Integer resultId) {
        return null;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Result record) {
        boolean flag = false;
        int x;
        System.out.println("grade=="+record.toString());
        x=resultMapper.updateByPrimaryKeySelective(record);
        System.out.println("x= ======================================="+x);
        if(x>=0)
            flag = true;
        return flag;
    }

    @Override
    public boolean updateByPrimaryKey(Result record) {
        boolean flag = false;
        int x;
        System.out.println("grade=="+record.toString());
        x=resultMapper.updateByPrimaryKey(record);
        System.out.println("x= ======================================="+x);
        if(x>=0)
            flag = true;
        return flag;
    }

    @Override
    public List<Result> getResultListProjectId(String studentId) {
        return resultMapper.getResultListProjectId(studentId);
    }

    @Override
    public List<Result> getResultList(String studentName) {
        return resultMapper.getResultList(studentName);
    }

    @Override
    public List<Result> getApplyListStudentId(String studentId) {
        return null;
    }

    @Override
    public Result getResultById(Integer resultId) {
        return resultMapper.getResultById(resultId);
    }

    @Override
    public Result getResult(String studentName) {
        return resultMapper.getResult(studentName);
    }

    @Override
    public List<Result> getResultByProjectId(Integer projectId) {
        return resultMapper.getResultByProjectId(projectId);
    }

    @Override
    public boolean getResultCountbyProjectId(Integer projectId) {
        return false;
    }

    @Override
    public List<Result> queryExcelInfooo() {
        return resultMapper.queryExcelInfooo();
    }


}
