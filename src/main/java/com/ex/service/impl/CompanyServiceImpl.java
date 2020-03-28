package com.ex.service.impl;

import com.ex.dao.CompanyMapper;
import com.ex.model.Company;
import com.ex.model.Student;
import com.ex.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    CompanyMapper companyMapper;

    @Override
    public List<Company> getCompanyList() {
        List<Company> companyList = null;
        companyList = companyMapper.getCompanyList();
        return companyList;
    }

    @Override
    public Company selectCompanyId(String companyId) {
        return companyMapper.selectCompanyId(companyId);
    }

    @Override
    public boolean deleteCompanyId(String companyId) {
        boolean flag = false;
        if(companyMapper.deleteCompanyId(companyId)>0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


    @Override
    public boolean updateByPrimaryKey(Company company) {
        boolean flag = false;
        int x;

        x=companyMapper.updateByPrimaryKey(company);
        System.out.println("x= ======================================="+x);
        if(x>0)
            flag = true;
        return flag;
    }

    @Override
    public List<Company> queryExcelInfo() {
        return companyMapper.queryExcelInfo();
    }

    @Override
    public boolean insert(Company record) {
        boolean flag = false;
        if(companyMapper.insert(record) > 0)
            flag = true;
        return flag;
    }

    @Override
    public boolean delCompanyById(String companyId) {
        if(companyMapper.delCompanyById(companyId)>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Company> selectId(String companyId) {
        List<Company> companyList = null;
        companyList = companyMapper.selectId(companyId);
        return companyList;
    }
}
