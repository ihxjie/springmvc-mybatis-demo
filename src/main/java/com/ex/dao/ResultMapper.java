package com.ex.dao;

import com.ex.model.Result;

import java.util.List;

public interface ResultMapper {
    int deleteByPrimaryKey(Integer resultId);

    int insert(Result record);

    int insertSelective(Result record);

    Result selectByPrimaryKey(Integer resultId);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKey(Result record);




    List<Result> getResultListProjectId(String studentId);

    List<Result> getResultList(String studentName);

    List<Result> getApplyListStudentId(String studentId);

    Result getResultById(Integer resultId);

    Result getResult(String studentName);

    List<Result> getResultByProjectId(Integer projectId);

    int getResultCountbyProjectId(Integer projectId);

    List<Result> queryExcelInfooo();


}