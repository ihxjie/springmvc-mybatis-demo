package com.ex.controller;

import com.alibaba.fastjson.JSONArray;
import com.ex.model.Company;
import com.ex.model.Student;
import com.ex.service.CompanyService;
import com.ex.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class CompanyController {
    @Resource
    private CompanyService companyService;
    private Logger logger = Logger.getLogger(CompanyController.class);
    @RequestMapping(value = "/companyList", method = RequestMethod.GET)
    public String getCompanyList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Company> companyList  = companyService.getCompanyList();
        //使用PageInfo包装数据
        PageInfo<Company> pageInfo=new PageInfo<Company>(companyList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("companyList",companyList);
        return "companyList";
    }
    @RequestMapping(value="/sys/companyList/view/{companyId}",method=RequestMethod.GET)
    public String view(@PathVariable String companyId, Model model, HttpServletRequest request){
        logger.debug("view id===================== "+companyId);
        Company company = new Company();
        try {
            company =companyService.selectCompanyId(companyId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(company);
        return "companyview";
    }
    @RequestMapping(value="/sys/companyList/looklist.html",method=RequestMethod.POST)
    public String viewstudent(Model model,
                              @RequestParam(value="companyId",required=false) String companyId,
                              @RequestParam(value="page",required=false) String page) {
        PageHelper.startPage(Integer.parseInt(page), 8);
        //紧跟的第一个select方法被分页
        List<Company> companyList = companyService.selectId(companyId);
        //使用PageInfo包装数据
        PageInfo<Company> pageInfo = new PageInfo<Company>(companyList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("companyList", companyList);
        return "companyList";
    }
    @RequestMapping("/sys/companyList/add.html")
    public String addCompany() {
        return "addCompany";
    }
    @RequestMapping(value="/sys/companyList/addStudent.html",method=RequestMethod.POST)
    public String addStudentSave(Company company, HttpSession session, HttpServletRequest request){
        System.out.println("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"+company.getCompanyId());
        try {
            if(companyService.insert(company)){
                return "redirect:/companyList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "404";
    }
    @RequestMapping(value="/delCompany",method=RequestMethod.POST)
    @ResponseBody
    public Object delCompany(@RequestParam(value="companyId" ,required=true) String companyId)
    {
        boolean flag = true;
        if(!companyService.deleteCompanyId(companyId))
        {
            flag = false;
        }
        return JSONArray.toJSONString(flag);
    }
    @RequestMapping(value="/delCompanys",method=RequestMethod.POST)
    @ResponseBody
    public Object delCompanys(@RequestParam(value="list" ,required=false) List<String>list) throws Exception
    {
        boolean flag = true;
        for(String id : list) {
            if(!companyService.delCompanyById(id))
            {
                flag = false;
            }
        }
        return JSONArray.toJSONString(flag);
    }

    @RequestMapping(value="/sys/companyList/modify/{companyId}",method=RequestMethod.GET)
    public String getStudentModify(@PathVariable String companyId,Model model,HttpServletRequest request){
        logger.debug("getProviderById typeId===================== "+companyId);
        Company company = new Company();
        try {
            company = companyService.selectCompanyId(companyId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("getProviderById companyId===================== "+company .getCompanyId());
        model.addAttribute(company );
        return "updatecompany";
    }
    @RequestMapping(value="/sys/companyList/modifysave.html",method=RequestMethod.POST)
    public String modifyCompanySave(Company company){
        logger.debug("modifyGoodsSave id===================== "+company.getCompanyName());
        try {
            if(companyService.updateByPrimaryKey(company)){
                return "redirect:/companyList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "updatestudent";
    }
    @RequestMapping("/sys/companyController/excel")
    public void excel(HttpServletResponse response )throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Company> list =companyService.queryExcelInfo();
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("公司信息表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("公司账号");
        titleRow.createCell(1).setCellValue("公司名字");
        titleRow.createCell(2).setCellValue("公司地址");
        titleRow.createCell(3).setCellValue("联系人");
        titleRow.createCell(4).setCellValue("联系人电话");

        //遍历将数据放到excel列中
        for (Company company : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(company.getCompanyId());
            dataRow.createCell(1).setCellValue(company.getCompanyName());
            dataRow.createCell(2).setCellValue(company.getCompanyAddress());
            dataRow.createCell(3).setCellValue(company.getContactName());
            dataRow.createCell(4).setCellValue(company.getContactTel());
        }

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("公司名单".getBytes(),"iso-8859-1") + ".xls");


        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();


    }
}
