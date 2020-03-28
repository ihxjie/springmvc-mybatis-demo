package com.ex.dao;

import com.ex.model.Company;
import com.ex.model.Project;
import com.ex.model.StudentTable;

import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(String companyId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String companyId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<StudentTable> selectStudentTable(Integer projectId);

}