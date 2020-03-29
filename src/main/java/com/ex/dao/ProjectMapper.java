package com.ex.dao;

import com.ex.model.Project;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(String projectId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String projectId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);




    Project getProjectById(String projectId);

    Project getProject(String projectTitle);

    List<Project> getProjectList(String projectTitle);

    List<Project> getProjectLiist(String projectTitle);

    int getProjectCount();

    List<Project> getProjectByWorkId(String workId);

}