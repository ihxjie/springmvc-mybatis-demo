package com.ex.controller;

import com.ex.dao.CompanyMapper;
import com.ex.model.Student;
import com.ex.model.StudentTable;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class CompanyController {

    @Resource
    CompanyMapper companyMapper;

    @GetMapping("excel/{projectId}")
    public void excel_training_table(@PathVariable Integer projectId, HttpServletResponse response)throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<StudentTable> list = companyMapper.selectStudentTable(projectId);
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("实训表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("学生/老师");
        titleRow.createCell(1).setCellValue("学生/老师ID");
        titleRow.createCell(2).setCellValue("学生/老师姓名");
        titleRow.createCell(3).setCellValue("缴费状态");
        titleRow.createCell(4).setCellValue("成绩");

        //遍历将数据放到excel列中
        for (StudentTable item : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            if (item.getIsStudent() == 0){
                dataRow.createCell(0).setCellValue("老师");
            }else {
                dataRow.createCell(0).setCellValue("学生");
            }

            dataRow.createCell(1).setCellValue(item.getPersonId());
            dataRow.createCell(2).setCellValue(item.getPersonName());
            if (item.getStatus() == null){
                dataRow.createCell(3).setCellValue("无需缴费");
            }else if (item.getStatus() == 0){
                dataRow.createCell(3).setCellValue("未缴费");
            }else {
                dataRow.createCell(3).setCellValue("已缴费");
            }
            if (item.getResult() == null){
                dataRow.createCell(4).setCellValue("");
            }else {
                dataRow.createCell(4).setCellValue(item.getResult());
            }

        }

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("实训名单".getBytes(),"iso-8859-1") + ".xls");


        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
}
