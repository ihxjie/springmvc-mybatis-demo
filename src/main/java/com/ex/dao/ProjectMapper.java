package com.ex.dao;

import com.ex.model.Project;
import com.ex.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {

    int insert(Project record);

    int insertSelective(Project record);

    Project selectProjectId(Integer projectId);//查询

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);//修改

    List<Project> getProjectList();//获取全部

    List<Project> queryExcelInfo();//导表

    boolean  updatestatus (@Param("projectId")Integer projectId, @Param("status")Integer status)throws Exception;//修改状态

    public int delProjectById(Integer projectId);//批量删除
    List<Project> selectId(Integer projectId);//查询
}