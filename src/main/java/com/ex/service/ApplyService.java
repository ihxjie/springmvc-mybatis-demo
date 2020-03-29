package com.ex.service;

import com.ex.model.Apply;
import com.ex.model.Result;

import java.util.List;

public interface ApplyService {
    boolean deleteByPrimaryKey(Integer applyId);

    boolean insert(Apply record);

    boolean insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer applyId);

    boolean updateByPrimaryKeySelective(Apply record);

    boolean updateByPrimaryKey(Apply record);





    List<Apply> getApplyList(String personName);

    List<Apply> getApplyListStudent(Integer projectId);

    Apply getApply(Integer applyId);

    Apply getApplyById(String personId);

    List<Apply> getApplyByProjectId(Integer projectId);

    int getApplyCountByProjectId(Integer projectId);

    int getApplyCount();

    List<Apply> getApplyByProjectIdIspay(Integer projectId);

    List<Apply> queryExcelInfo();
}
