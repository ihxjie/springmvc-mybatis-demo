package com.ex.model;

public class Feedback {
    private Integer feedbackId;

    private String teacherId;

    private String studentId;

    private Integer projectId;

    private Integer option1;

    private Integer option2;

    private Integer option3;

    private Integer option4;

    private Integer option5;

    private Integer option6;

    private Integer option7;

    private Integer option8;

    private String forUs;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getOption1() {
        return option1;
    }

    public void setOption1(Integer option1) {
        this.option1 = option1;
    }

    public Integer getOption2() {
        return option2;
    }

    public void setOption2(Integer option2) {
        this.option2 = option2;
    }

    public Integer getOption3() {
        return option3;
    }

    public void setOption3(Integer option3) {
        this.option3 = option3;
    }

    public Integer getOption4() {
        return option4;
    }

    public void setOption4(Integer option4) {
        this.option4 = option4;
    }

    public Integer getOption5() {
        return option5;
    }

    public void setOption5(Integer option5) {
        this.option5 = option5;
    }

    public Integer getOption6() {
        return option6;
    }

    public void setOption6(Integer option6) {
        this.option6 = option6;
    }

    public Integer getOption7() {
        return option7;
    }

    public void setOption7(Integer option7) {
        this.option7 = option7;
    }

    public Integer getOption8() {
        return option8;
    }

    public void setOption8(Integer option8) {
        this.option8 = option8;
    }

    public String getForUs() {
        return forUs;
    }

    public void setForUs(String forUs) {
        this.forUs = forUs == null ? null : forUs.trim();
    }
}