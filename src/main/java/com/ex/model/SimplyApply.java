package com.ex.model;

public class SimplyApply {
    private Integer applyId;

    private Integer projectId;

    private String personId;

    private String personName;

    private Integer status;

    private String projectTitle;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    @Override
    public String toString() {
        return "SimplyApply{" +
                "applyId=" + applyId +
                ", projectId=" + projectId +
                ", personId='" + personId + '\'' +
                ", personName='" + personName + '\'' +
                ", status=" + status +
                ", projectTitle='" + projectTitle + '\'' +
                '}';
    }
}
