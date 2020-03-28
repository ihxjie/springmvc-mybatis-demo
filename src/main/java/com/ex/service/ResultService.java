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
}
