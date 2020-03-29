package com.ex.dao;

import com.ex.model.Grade;
import com.ex.model.Result;

import java.util.List;

public interface ResultMapper {
    int deleteByPrimaryKey(Integer resultId);

    int insert(Result record);

    int insertSelective(Result record);

    Result selectByPrimaryKey(Integer resultId);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKey(Result record);

    List<Grade> selectStudentResult(String studentId);

    List<Result> getResultList();//

    Result getResultByStudentId(String studentId);//

    List<Result> queryExcelInfo();//导表

    int delResultById(String resultId);//批量删除

    List<Result> selectId(String studentId);//查询

    List<Result> getResultListProjectId(String studentId);

    Result getResultById(Integer resultId);

    Result getResult(String studentName);

    List<Result> getResultByProjectId(Integer projectId);

    int getResultCountbyProjectId(Integer projectId);

    List<Result> queryExcelInfooo();
}