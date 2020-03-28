package com.ex.model;

public class Reason {
    private Integer projectid;

    private String refuse;

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getRefuse() {
        return refuse;
    }

    public void setRefuse(String refuse) {
        this.refuse = refuse == null ? null : refuse.trim();
    }
}