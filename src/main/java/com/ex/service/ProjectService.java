package com.ex.service;

import com.ex.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectService {
    List<Project> getProjectList();//获取全部项目信息

    Project selectProjectId(Integer projectId);//根据id查找

    boolean updateByPrimaryKey(Project project);//修改

    boolean  updatestatus (@Param("projectId")Integer projectId, @Param("status")Integer status)throws Exception;

    List<Project> queryExcelInfo();//导表

    boolean delProjectById(Integer projectId);//批量删除

    List<Project> selectId(Integer projectId);

    //boolean deleteByPrimaryKey(String projectId);

    boolean insert(Project record);

    boolean insertSelective(Project record);

    Project selectByPrimaryKey(String projectId);

    boolean updateByPrimaryKeySelective(Project record);




    Project getProjectById(String projectId);

    List<Project> getProjectList(String projectTitle);//获得全部信息

    List<Project> getProjectLiist(String projectTitle);

    List<Project> getProjectByWorkId(String workId);


    Project selectProjectExist(String projectTitle);

}