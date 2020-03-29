package com.ex.model;

public class Project {
    private Integer projectId;

    private Integer isCompany;

    private String workId;

    private String projectTitle;

    private String period;

    private String projectContent;

    private String projectAddress;

    private String projectPrice;

    private Integer status;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getIsCompany() {
        return isCompany;
    }

    public void setIsCompany(Integer isCompany) {
        this.isCompany = isCompany;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle == null ? null : projectTitle.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent == null ? null : projectContent.trim();
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    public String getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(String projectPrice) {
        this.projectPrice = projectPrice == null ? null : projectPrice.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}