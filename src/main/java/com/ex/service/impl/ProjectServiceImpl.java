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
    public boolean deleteByPrimaryKey(String  projectId) {
        boolean flag = true;
        if(projectMapper.deleteByPrimaryKey(projectId) < 1)
            flag = false;
        return flag;
    }

    @Override
    public boolean insert(Project record) {
        // TODO Auto-generated method stub
        boolean flag = false;
        if(projectMapper.insert(record) > 0)
            flag = true;
        return flag;
    }

    @Override
    public boolean insertSelective(Project record) {
        // TODO Auto-generated method stub
        boolean flag = false;
        if(projectMapper.insert(record) > 0)
            flag = true;
        return flag;
    }

    @Override
    public Project selectByPrimaryKey(String projectId) {
        return null;
    }


    @Override
    public boolean updateByPrimaryKeySelective(Project record) {
        boolean flag = false;
        int x;

        x=projectMapper.updateByPrimaryKeySelective(record);
        System.out.println("x= ======================================="+x);
        if(x>0)
            flag = true;
        return flag;
    }

    @Override
    public boolean updateByPrimaryKey(Project record) {
        boolean flag = false;
        int x;

        x=projectMapper.updateByPrimaryKey(record);
        System.out.println("x= ======================================="+x);
        if(x>0)
            flag = true;
        return flag;
    }

    @Override
    public Project selectProjectExist(String projectTitle) {
        return projectMapper.getProject(projectTitle);
    }


    @Override
    public Project getProjectById(String projectId) {
        return projectMapper.getProjectById(projectId);
    }


    @Override
    public List<Project> getProjectList(String projectTitle) {
        List<Project> projectlist = null;
        projectlist = projectMapper.getProjectList(projectTitle);
        return projectlist;
    }

    @Override
    public List<Project> getProjectLiist(String projectTitle) {
        List<Project> projectlist = null;
        projectlist = projectMapper.getProjectLiist(projectTitle);
        return projectlist;
    }

    @Override
    public List<Project> getProjectByWorkId(String workId) {
        List<Project> projectlist = null;
        projectlist = projectMapper.getProjectByWorkId(workId);
        return projectlist;
    }


}
