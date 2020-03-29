package com.ex.service;

import com.ex.model.Result;

import java.util.List;

public interface ResultService {
    List<Result> getResultList();//获取全部信息

    // Result selectByPrimaryKey(String studentId);//查询

    //boolean deleteByPrimaryKey(String studentId);

    Result getResultById(String studentId);//根据id查询

    boolean updateByPrimaryKey(Result result);//修改

    List<Result> queryExcelInfo();//导表

    boolean delResultById(String resultId);//批量删除

    List<Result> selectId(String studentId);

    List<Result> getResultListProjectId(String studentId);

    List<Result> getResultList(String studentName);

    List<Result> getApplyListStudentId(String studentId);

    Result getResultById(Integer resultId);

    Result getResult(String studentName);

    List<Result> getResultByProjectId(Integer projectId);

    boolean getResultCountbyProjectId(Integer ProjectId);

    List<Result> queryExcelInfooo();

    boolean insert(Result record);
}
