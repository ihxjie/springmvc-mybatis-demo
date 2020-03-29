package com.ex.dao;

import com.ex.model.Apply;
import com.ex.model.Result;

import java.util.List;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer applyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);



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