package com.ex.service;

import com.ex.model.Company;
import com.ex.model.Student;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanyList();//获取所有公司信息

    Company selectCompanyId(String companyId);//查询

    boolean deleteCompanyId(String companyId);//根据id删除

    //Company getCompanyById(String companyId);//根据id查询

    boolean updateByPrimaryKey(Company company);//修改公司信息

    List<Company> queryExcelInfo();//导表

    boolean insert(Company record);//插入

    boolean delCompanyById(String companyId);//批量删除
    List<Company> selectId(String companyId);//根据id查询在本页面显示

}
