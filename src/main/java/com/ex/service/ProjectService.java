package com.ex.service;

import com.ex.model.Project;

import java.util.List;

public interface ProjectService {

    boolean deleteByPrimaryKey(String projectId);

    boolean insert(Project record);

    boolean insertSelective(Project record);

    Project selectByPrimaryKey(String projectId);

    boolean updateByPrimaryKeySelective(Project record);




    Project getProjectById(String projectId);

    List<Project> getProjectList(String projectTitle);//获得全部信息

    List<Project> getProjectLiist(String projectTitle);

    List<Project> getProjectByWorkId(String workId);

    boolean updateByPrimaryKey(Project project);

    Project selectProjectExist(String projectTitle);
}
