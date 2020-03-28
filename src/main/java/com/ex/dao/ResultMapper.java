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
}