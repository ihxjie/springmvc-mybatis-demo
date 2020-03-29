package com.ex.service.impl;

import com.ex.dao.ApplyMapper;
import com.ex.model.Apply;
import com.ex.service.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ApplyServiceImpl implements ApplyService {
    @Resource
    private ApplyMapper applyMapper;

    @Override
    public List<Apply> getApplyList() {
        List<Apply> applyList = null;
        applyList = applyMapper.getApplyList();
        return applyList;
    }

    @Override
    public Apply selectApplyId(Integer applyId) {
        return applyMapper.selectApplyId(applyId);
    }


    @Override
    public boolean updateApply(Apply apply) {
        boolean flag = false;
        int x;

        x=applyMapper.updateApply(apply);
        System.out.println("x= ======================================="+x);
        if(x>0)
            flag = true;
        return flag;
    }

    @Override
    public List<Apply> queryExcelInfo() {
        return applyMapper.queryExcelInfo();
    }

    @Override
    public boolean delApplyById(Integer applyId) {
        if(applyMapper.delApplyById(applyId)>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Apply> selectId(Integer applyId) {
        List<Apply> applyList = null;
        applyList = applyMapper.selectId(applyId);
        return applyList;
    }
    @Override
    public boolean deleteByPrimaryKey(Integer applyId) {
        boolean flag = true;
        if (applyMapper.deleteByPrimaryKey(applyId) < 1)
            flag = false;
        return flag;
    }

    @Override
    public List<Apply> getApplyList(String personName) {
        return applyMapper.getApplyListByPersonName(personName);
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
    public List<Apply> queryExcel() {
        return applyMapper.queryExcel();
    }
}
