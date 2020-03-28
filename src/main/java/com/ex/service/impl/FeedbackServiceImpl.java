package com.ex.service.impl;

import com.ex.dao.FeedbackMapper;
import com.ex.model.Feedback;
import com.ex.model.Student;
import com.ex.service.FeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public List<Feedback> getFeedbackList() {
        List<Feedback> feedbackList = null;
        feedbackList = feedbackMapper.getFeedbackList();
        return feedbackList;
    }

    @Override
    public Feedback lookTeacherId(String teacherId) {
        return feedbackMapper.lookTeacherId(teacherId);
    }

    @Override
    public List<Feedback> selectId(String teacherId) {
        List<Feedback> feedbackList = null;
        feedbackList = feedbackMapper.selectId(teacherId);
        return feedbackList;
    }
}
