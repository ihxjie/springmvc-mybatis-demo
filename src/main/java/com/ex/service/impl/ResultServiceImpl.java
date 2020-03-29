package com.ex.service.impl;

import com.ex.dao.ResultMapper;
import com.ex.model.Result;
import com.ex.model.Student;
import com.ex.service.ResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    ResultMapper  resultMapper;
    @Resource
    ResultService resultService;


    @Override
    public List<Result> getResultList() {
        List< Result> resultList = null;
        resultList = resultMapper.getResultList();
        return resultList;
    }


    @Override
    public Result getResultById(String studentId) {
        return resultMapper.getResultByStudentId(studentId);
    }

    @Override
    public boolean updateByPrimaryKey(Result result) {
        boolean flag = false;
        int x;

        x=resultMapper.updateByPrimaryKey(result);
        System.out.println("x= ======================================="+x);
        if(x>0)
            flag = true;
        return flag;
    }

    @Override
    public List<Result> queryExcelInfo() {
        return resultMapper.queryExcelInfo();
    }

    @Override
    public boolean delResultById(String resultId) {
        if(resultMapper.delResultById(resultId)>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Result> selectId(String studentId) {
        List<Result> resultList = null;
        resultList =resultMapper.selectId(studentId);
        return resultList;
    }

    @Override
    public List<Result> getResultListProjectId(String studentId) {
        return resultMapper.getResultListProjectId(studentId);
    }

    @Override
    public List<Result> getResultList(String studentName) {
        return resultMapper.getResultList();
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

    @Override
    public boolean insert(Result record) {
        boolean flag = false;
        if(resultMapper.insert(record) > 0)
            flag = true;
        return flag;
    }
}
