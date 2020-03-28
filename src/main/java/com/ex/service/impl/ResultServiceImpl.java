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


    @Override
    public List<Result> getResultList() {
        List< Result> resultList = null;
        resultList = resultMapper.getResultList();
        return resultList;
    }


    @Override
    public Result getResultById(String studentId) {
        return resultMapper.getResultById(studentId);
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
}
