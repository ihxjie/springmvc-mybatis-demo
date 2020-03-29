package com.ex.service;

import com.ex.model.Result;

import java.util.List;

public interface ResultService {
    boolean deleteByPrimaryKey(Integer resultId);

    boolean insert(Result record);

    boolean insertSelective(Result record);

    Result selectByPrimaryKey(Integer resultId);

    boolean updateByPrimaryKeySelective(Result record);

    boolean updateByPrimaryKey(Result record);




    List<Result> getResultListProjectId(String studentId);

    List<Result> getResultList(String studentName);

    List<Result> getApplyListStudentId(String studentId);

    Result getResultById(Integer resultId);

    Result getResult(String studentName);

    List<Result> getResultByProjectId(Integer projectId);

    boolean getResultCountbyProjectId(Integer ProjectId);

    List<Result> queryExcelInfooo();
}
