package com.ex.service.impl;

import com.ex.dao.ProjectMapper;
import com.ex.model.Project;
import com.ex.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectMapper projectMapper;

    @Override
    public List<Project> getProjectList() {
        List<Project> projectList = null;
        projectList = projectMapper.getProjectList();
        return projectList;
    }

    @Override
    public Project selectProjectId(Integer projectId) {
        return projectMapper.selectProjectId(projectId);
    }


    @Override
    public boolean updateByPrimaryKey(Project project) {
        boolean flag = false;
        int x;

        x=projectMapper.updateByPrimaryKey(project);
        System.out.println("x= ======================================="+x);
        if(x>0)
            flag = true;
        return flag;
    }

    @Override
    public boolean updatestatus(Integer projectId, Integer status) throws Exception {
        return projectMapper.updatestatus(projectId,status);
    }


    @Override
    public List<Project> queryExcelInfo() {
        return projectMapper.queryExcelInfo();
    }

    @Override
    public boolean delProjectById(Integer projectId) {
        if(projectMapper.delProjectById(projectId)>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Project> selectId(Integer projectId) {
        List<Project> projectList = null;
        projectList = projectMapper.selectId(projectId);
        return projectList;
    }

}
