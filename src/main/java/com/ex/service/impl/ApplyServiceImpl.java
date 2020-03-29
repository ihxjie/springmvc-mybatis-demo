package com.ex.service.impl;

import com.ex.dao.ApplyMapper;
import com.ex.model.Apply;
import com.ex.model.Result;
import com.ex.service.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Resource
    ApplyMapper applyMapper;

    @Override
    public boolean deleteByPrimaryKey(Integer applyId) {
        boolean flag = true;
        if(applyMapper.deleteByPrimaryKey(applyId) < 1)
            flag = false;
        return flag;
    }

    @Override
    public boolean insert(Apply record) {
        return false;
    }

    @Override
    public boolean insertSelective(Apply record) {
        return false;
    }

    @Override
    public Apply selectByPrimaryKey(Integer applyId) {
        return null;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Apply record) {
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(Apply record) {
        return false;
    }




    @Override
    public List<Apply> getApplyList(String personName) {
        return applyMapper.getApplyList(personName);
    }

    @Override
    public List<Apply> getApplyListStudent(Integer projectId) {
        return applyMapper.getApplyListStudent(projectId);
    }

    @Override
    public Apply getApply(Integer applyId) {
        return applyMapper.getApply(applyId);
    }

    @Override
    public Apply getApplyById(String personId) {
        return applyMapper.getApplyById(personId);
    }

    @Override
    public List<Apply> getApplyByProjectId(Integer projectId) {
        return applyMapper.getApplyByProjectId(projectId);
    }

    @Override
    public int getApplyCountByProjectId(Integer projectId) {
        return applyMapper.getApplyCountByProjectId(projectId);
    }

    @Override
    public int getApplyCount() {
        return applyMapper.getApplyCount();
    }

    @Override
    public List<Apply> getApplyByProjectIdIspay(Integer projectId) {
        return applyMapper.getApplyByProjectIdIspay(projectId);
    }

    @Override
    public List<Apply> queryExcelInfo() {
        return applyMapper.queryExcelInfo();
    }
}
