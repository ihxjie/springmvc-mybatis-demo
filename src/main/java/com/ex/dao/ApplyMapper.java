package com.ex.dao;

import com.ex.model.Apply;
import com.ex.model.SimplyApply;
import org.apache.ibatis.annotations.Param;
import com.ex.model.Student;

import java.util.List;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer applyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

    Apply selectEnrollInfo(@Param("studentId") String studentId, @Param("projectId") Integer projectId);

    List<SimplyApply> getStudentApply(@Param("studentId") String studentId);

    List<Apply> getTeacherApply(Integer projectId);

    Apply selectApplyId(Integer applyId);//

    int updateApply(Apply record);

    List<Apply> queryExcelInfo();

    List<Apply> getApplyList();//获取全部报名表

    int delApplyById(Integer applyId);

    List<Apply> selectId(Integer applyId);//根据id进行查询在该页面显示
}