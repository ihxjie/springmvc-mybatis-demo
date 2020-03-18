package com.ex.model;

import java.util.Date;

public class Border {
    private Integer borderId;

    private String borderTitle;

    private String borderContent;

    private Date borderPublishTime;

    public Integer getBorderId() {
        return borderId;
    }

    public void setBorderId(Integer borderId) {
        this.borderId = borderId;
    }

    public String getBorderTitle() {
        return borderTitle;
    }

    public void setBorderTitle(String borderTitle) {
        this.borderTitle = borderTitle == null ? null : borderTitle.trim();
    }

    public String getBorderContent() {
        return borderContent;
    }

    public void setBorderContent(String borderContent) {
        this.borderContent = borderContent == null ? null : borderContent.trim();
    }

    public Date getBorderPublishTime() {
        return borderPublishTime;
    }

    public void setBorderPublishTime(Date borderPublishTime) {
        this.borderPublishTime = borderPublishTime;
    }
}