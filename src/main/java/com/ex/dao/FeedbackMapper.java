package com.ex.dao;

import com.ex.model.Feedback;
import org.apache.ibatis.annotations.Param;
import com.ex.model.Student;

import java.util.List;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer feedbackId);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer feedbackId);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    Feedback getEvaluatedInfo(@Param("studentId") String studentId, @Param("projectId") Integer projectId,
                              @Param("teacherId") String teacherId);

    Feedback lookTeacherId(String teacherId);//

    List<Feedback> getFeedbackList();//

    List<Feedback> selectId(String teacherId);//
}