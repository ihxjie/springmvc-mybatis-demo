package com.ex.dao;

import com.ex.model.Company;
import com.ex.model.Student;

import java.util.List;

public interface CompanyMapper {
    int deleteCompanyId(String companyId);//

    int insert(Company record);//

    int insertSelective(Company record);

    Company selectCompanyId(String companyId);//

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> getCompanyList();

   // Company getCompanyById(String companyId);

    List<Company> queryExcelInfo();

    public int delCompanyById(String companyId);
    List<Company> selectId(String companyId);
}