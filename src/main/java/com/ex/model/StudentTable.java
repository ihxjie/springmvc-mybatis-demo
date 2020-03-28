package com.ex.model;

public class StudentTable {

    private String personId;

    private String personName;

    private Integer status;

    private Integer isStudent;

    private Integer result;

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

    public Integer getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(Integer isStudent) {
        this.isStudent = isStudent;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "StudentTable{" +
                "personId='" + personId + '\'' +
                ", personName='" + personName + '\'' +
                ", status=" + status +
                ", isStudent=" + isStudent +
                ", result=" + result +
                '}';
    }
}
