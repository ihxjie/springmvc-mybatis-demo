package com.ex.dao;

import com.ex.model.Apply;
import com.ex.model.Student;

import java.util.List;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectApplyId(Integer applyId);//

    int updateByPrimaryKeySelective(Apply record);

    int updateApply(Apply record);

    List<Apply> queryExcelInfo();

    List<Apply> getApplyList();//获取全部报名表

    public int delApplyById(Integer applyId);
    List<Apply> selectId(Integer applyId);//根据id进行查询在该页面显示
}