package com.ex.controller;

import com.alibaba.fastjson.JSONArray;
import com.ex.model.Apply;
import com.ex.model.Company;
import com.ex.model.Student;
import com.ex.service.ApplyService;
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
public class ApplyController {
    @Resource
    private ApplyService applyService;
    private Logger logger = Logger.getLogger(ApplyController.class);
    @RequestMapping(value = "/applyList", method = RequestMethod.GET)
    public String getApplyList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Apply> applyList  = applyService.getApplyList();
        //使用PageInfo包装数据
        PageInfo<Apply> pageInfo=new PageInfo<Apply>(applyList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("applyList",applyList);
        return "applyList";
    }

    @RequestMapping(value="/sys/applyList/looklist.html",method=RequestMethod.POST)
    public String viewapply(Model model,
                              @RequestParam(value="applyId",required=false) Integer applyId,
                              @RequestParam(value="page",required=false) String page) {
        PageHelper.startPage(Integer.parseInt(page), 8);
        //紧跟的第一个select方法被分页
        List<Apply> applyList = applyService.selectId(applyId);
        //使用PageInfo包装数据
        PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("applyList", applyList);
        return "applyList";
    }

    @RequestMapping(value="/sys/applyList/view/{applyId}",method=RequestMethod.GET)
    public String view(@PathVariable Integer applyId, Model model, HttpServletRequest request){
        logger.debug("view id===================== "+applyId);
        Apply apply= new Apply();
        try {
            apply =applyService.selectApplyId(applyId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(apply);
        return "applyview";
    }
    @RequestMapping(value="/delApplys",method=RequestMethod.POST)
    @ResponseBody
    public Object delGoods(@RequestParam(value="list" ,required=false) List<Integer>list) throws Exception
    {
        boolean flag = true;
        for(Integer id : list) {
            if(!applyService.delApplyById(id))
            {
                flag = false;
            }
        }
        return JSONArray.toJSONString(flag);
    }

    @RequestMapping(value="/sys/applyList/modify/{applyId}",method=RequestMethod.GET)
    public String getApplyModify(@PathVariable Integer applyId,Model model,HttpServletRequest request){
        logger.debug("getApplyById typeId===================== "+applyId);
        Apply apply= new Apply();
        try {
            apply= applyService.selectApplyId(applyId);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug("getApplyById companyId===================== "+apply .getApplyId());
        model.addAttribute(apply );
        return "updateapply";
    }
    @RequestMapping(value="/sys/applyList/modifysave.html",method=RequestMethod.POST)
    public String modifyApplySave(Apply apply){
        logger.debug("modifyApplySave id===================== "+apply.getApplyId());
        try {
            if(applyService.updateApply(apply)){
                return "redirect:/applyList.html";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "updateapply";
    }
    @RequestMapping("/sys/applyController/excel")
    public void excel(HttpServletResponse response )throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Apply> list =applyService.queryExcelInfo();
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("报名表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("报名id");
        titleRow.createCell(1).setCellValue("项目id");
        titleRow.createCell(2).setCellValue("报名人账号");
        titleRow.createCell(3).setCellValue("报名人姓名");
        titleRow.createCell(4).setCellValue("报名");

        //遍历将数据放到excel列中
        for (Apply apply: list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(apply.getApplyId());
            dataRow.createCell(1).setCellValue(apply.getProjectId());
            dataRow.createCell(2).setCellValue(apply.getPersonId());
            dataRow.createCell(3).setCellValue(apply.getPersonName());
            dataRow.createCell(4).setCellValue(apply.getIsStudent());
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
