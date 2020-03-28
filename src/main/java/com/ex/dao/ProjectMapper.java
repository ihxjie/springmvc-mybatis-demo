package com.ex.dao;

import com.ex.model.Project;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> selectProjectByNames(String keyword);

    List<Project> selectApplyingProject(String companyId);

    List<Project> selectPassedProject(String companyId);

    List<Project> selectRejectedProject(String companyId);

    Integer getID();
}