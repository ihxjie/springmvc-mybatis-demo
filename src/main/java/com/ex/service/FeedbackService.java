package com.ex.service;

import com.ex.model.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getFeedbackList();//获取全部信息


    List<Feedback> selectId(String teacherId);

    Feedback lookTeacherId(String teacherId);
}
