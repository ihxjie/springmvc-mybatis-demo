package com.ex.dao;

import com.ex.model.Project;
import com.ex.model.Student;
import org.apache.ibatis.annotations.Param;

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

    Project selectProjectId(Integer projectId);//查询

    List<Project> getProjectLists();//获取全部

    List<Project> queryExcelInfo();//导表

    boolean  updatestatus (@Param("projectId")Integer projectId, @Param("status")Integer status)throws Exception;//修改状态

    int delProjectById(Integer projectId);//批量删除

    List<Project> selectId(Integer projectId);//查询


    Project getProjectById(String projectId);

    Project getProject(String projectTitle);

    List<Project> getProjectList(String projectTitle);

    List<Project> getProjectLiist(String projectTitle);

    int getProjectCount();

    List<Project> getProjectByWorkId(String workId);

}