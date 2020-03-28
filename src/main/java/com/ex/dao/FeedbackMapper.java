package com.ex.dao;

import com.ex.model.Feedback;
import com.ex.model.Student;

import java.util.List;

public interface FeedbackMapper {
    Feedback lookTeacherId(String teacherId);//

    List<Feedback> getFeedbackList();//

    List<Feedback> selectId(String teacherId);//
}