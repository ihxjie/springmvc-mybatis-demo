package com.ex.model;

public class Reason {
    private Integer projectId;

    private String refuse;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getRefuse() {
        return refuse;
    }

    public void setRefuse(String refuse) {
        this.refuse = refuse == null ? null : refuse.trim();
    }
}