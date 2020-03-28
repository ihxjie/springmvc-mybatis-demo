package com.ex.controller;

import com.alibaba.fastjson.JSONArray;
import com.ex.model.Result;
import com.ex.model.Student;
import com.ex.service.ResultService;
import com.ex.service.StudentService;
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
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class ResultController {
@Resource
private ResultService resultService;
    private Logger logger = Logger.getLogger(ResultController.class);
    @RequestMapping(value = "/resultList", method = RequestMethod.GET)
    public String getResultList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Result> resultList  = resultService.getResultList();
        //使用PageInfo包装数据
        PageInfo<Result> pageInfo=new PageInfo<Result>(resultList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("resultList",resultList);
        return "resultList";
    }

    @RequestMapping(value="/sys/resultList/looklist.html",method=RequestMethod.POST)
    public String viewresult(Model model,
                              @RequestParam(value="studentId",required=false) String studentId,
                              @RequestParam(value="page",required=false) String page) {
        PageHelper.startPage(Integer.parseInt(page), 8);
        //紧跟的第一个select方法被分页
        List<Result> resultList = resultService.selectId(studentId);
        //使用PageInfo包装数据
        PageInfo<Result> pageInfo = new PageInfo<Result>(resultList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("resultList", resultList);
        return "resultList";
    }

    @RequestMapping(value="/sys/resultList/view/{studentId}",method=RequestMethod.GET)
    public String view(@PathVariable String studentId, Model model, HttpServletRequest request){
        logger.debug("view id===================== "+studentId);
        Result result = new Result();
        try {
            result =resultService.getResultById(studentId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(result);
        return "resultview";
    }
    @RequestMapping(value="/delResults",method=RequestMethod.POST)
    @ResponseBody
    public Object delGoods(@RequestParam(value="list" ,required=false) List<String>list) throws Exception
    {
        boolean flag = true;
        for(String id : list) {
            if(!resultService.delResultById(id))
            {
                flag = false;
            }
        }
        return JSONArray.toJSONString(flag);
    }

    @RequestMapping(value="/sys/resultList/modify/{studentId}",method=RequestMethod.GET)
    public String getResultModify(@PathVariable String studentId,Model model,HttpServletRequest request){
        logger.debug("getProviderById typeId===================== "+studentId);
        Result result = new Result();
        try {
            result= resultService.getResultById(studentId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("getProviderById studentId===================== "+result .getStudentId());
        model.addAttribute(result);
        return "updateresult";
    }
    @RequestMapping(value="/sys/resultList/modifysave.html",method=RequestMethod.POST)
    public String modifyResultSave(Result result){
        logger.debug("modifyResultSave id===================== "+result.getResultId());
        try {
            if(resultService.updateByPrimaryKey(result)){
                return "redirect:/resultList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "updateresult";
    }
    @RequestMapping("/sys/resultController/excel")
    public void excel(HttpServletResponse response )throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Result> list =resultService.queryExcelInfo();
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("学生成绩");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("成绩id");
        titleRow.createCell(1).setCellValue("学生账号");
        titleRow.createCell(2).setCellValue("项目id");
        titleRow.createCell(3).setCellValue("学生姓名");
        titleRow.createCell(4).setCellValue("学生成绩");

        //遍历将数据放到excel列中
        for (Result result : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(result.getResultId());
            dataRow.createCell(1).setCellValue(result.getStudentId());
            dataRow.createCell(2).setCellValue(result.getProjectId());
            dataRow.createCell(3).setCellValue(result.getStudentName());
            dataRow.createCell(4).setCellValue(result.getResult());
        }

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("学生成绩名单".getBytes(),"iso-8859-1") + ".xls");


        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();


    }
}
