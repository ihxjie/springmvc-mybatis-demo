package com.ex.controller;

import com.alibaba.fastjson.JSONArray;
import com.ex.model.Apply;
import com.ex.model.Company;
import com.ex.model.Student;
import com.ex.service.ApplyService;
import com.ex.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.alibaba.fastjson.JSONObject;
import com.ex.dao.ApplyMapper;
import com.ex.dao.FeedbackMapper;
import com.ex.dao.ProjectMapper;
import com.ex.model.Apply;
import com.ex.model.Feedback;
import com.ex.model.Project;
import com.ex.model.SimplyApply;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

@Controller
public class ApplyController {

    @Resource
    ApplyMapper applyMapper;
    @Resource
    ProjectMapper projectMapper;
    @Resource
    FeedbackMapper feedbackMapper;
    @Resource
    private ApplyService applyService;
    @Resource
    private ProjectService projectService;

    private Logger logger = Logger.getLogger(ApplyController.class);

    @GetMapping(value = "apply/getApply", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getApply(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum,
                           @RequestParam(defaultValue = "10",value = "pageSize") int pageSize,
                           @RequestParam(defaultValue = "", value = "keyword") String keyword,
                           HttpSession session) {
        String studentId = session.getAttribute("username").toString();

        PageHelper.startPage(pageNum,pageSize);
        List<SimplyApply> applyList = applyMapper.getStudentApply(studentId);

        PageInfo pageInfo = new PageInfo(applyList);
        //System.out.println(JSONObject.toJSONString(pageInfo, WriteMapNullValue));
        return JSONObject.toJSONString(pageInfo, WriteMapNullValue);


    }
    @GetMapping("payfor/{applyId}")
    public String payfor(@PathVariable Integer applyId, Model model){
        Apply apply = applyMapper.selectByPrimaryKey(applyId);
        Project project = projectMapper.selectByPrimaryKey(apply.getProjectId());
        model.addAttribute("projectTitle", project.getProjectTitle());
        model.addAttribute("projectContent", project.getProjectContent());
        model.addAttribute("projectPrice", project.getProjectPrice());
        model.addAttribute("applyId", applyId);
        return "payfor";
    }
    @GetMapping(value = "pay", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String pay(@RequestParam Integer applyId){

        Apply apply = applyMapper.selectByPrimaryKey(applyId);
        if (apply.getStatus() == 0){
            apply.setStatus(1);
            apply.setApplyId(applyId);
            applyMapper.updateByPrimaryKeySelective(apply);
            return "缴费成功";
        }
        return "缴费失败，您已经交过了";
    }
    @GetMapping(value = "drop", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String drop(@RequestParam Integer applyId, HttpSession session){
        Apply apply = applyMapper.selectByPrimaryKey(applyId);
        Project project = projectMapper.selectByPrimaryKey(apply.getProjectId());
        String username = session.getAttribute("username").toString();
        if (username.equals(apply.getPersonId())){
            applyMapper.deleteByPrimaryKey(applyId);
            return "您已成功退选：" + project.getProjectTitle();
        }
        return "非法操作，请检查是否登录";
    }
    @GetMapping(value = "teacher_evaluate", produces = "text/plain;charset=utf-8")
    public String teacher_evaluate(@RequestParam Integer applyId, Model model, HttpSession session){
        Apply apply = applyMapper.selectByPrimaryKey(applyId);

        List<Apply> teacherApply = applyMapper.getTeacherApply(apply.getProjectId());
        model.addAttribute("applyId", applyId);
        if (teacherApply.size() != 0){
            model.addAttribute("teacherApply", teacherApply);
            model.addAttribute("teacherName", teacherApply.get(0).getPersonName());
            model.addAttribute("teacherId", teacherApply.get(0).getPersonId());
            session.setAttribute("projectId", apply.getProjectId());
            return "feedback";
        }
        model.addAttribute("info", "未有老师报名，无法评价");
        return "enrolment";
    }

    @PostMapping(value = "single_evaluate", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String single_evaluate(@ModelAttribute Feedback feedback, HttpSession session) {

        System.out.println(feedback);

        String studentId = session.getAttribute("username").toString();
        Integer projectId = Integer.parseInt(session.getAttribute("projectId").toString());

        Feedback f = feedbackMapper.getEvaluatedInfo(studentId, projectId, feedback.getTeacherId());
        if (f == null) {
            feedback.setStudentId(studentId);
            feedback.setProjectId(projectId);
            feedbackMapper.insertSelective(feedback);
            return "评价成功！";
        }

        return "无需重复评价";

    }

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
    @RequestMapping(value = "/sys/applylist/pass", method = RequestMethod.GET)
    public String getProjectlistpass(String workId,@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        //获取指定页数据，大小为8
        PageHelper.startPage(page, 8);
        //紧跟的第一个select方法被分页
        List<Project> projectList = null;
        projectList = projectService.getProjectByWorkId(workId);
        //使用PageInfo包装数据
        PageInfo<Project> pageInfo = new PageInfo<Project>(projectList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("projectList", projectList);
        return "projectapply";
    }

    @RequestMapping(value="/sys/applylist/list/{projectId}")
    public String getEnrollList(Model model, @PathVariable String projectId,@RequestParam(value = "page", defaultValue = "1") Integer page){
        System.out.println("0000000000"+projectId);
        PageHelper.startPage(page, 8);
        List<Apply> applyList = null;
        applyList=applyService.getApplyByProjectId(Integer.valueOf(projectId));
        PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("applyList", applyList);
        model.addAttribute("applyprojectId", projectId);
        return "applylist";
    }


    @RequestMapping(value="/sys/applylist/list.html")
    public String getApplyList(Model model, String personName){
        logger.info("getUserList ---- > goodsName: " + personName);
        List<Apply> applyList = null;
        try {
            applyList = applyService.getApplyList(personName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("applyList", applyList);
        return "projectapply";
    }

    @RequestMapping(value="/view/{applyId}",method= RequestMethod.GET)
    public String view(@PathVariable String applyId, Model model, HttpServletRequest request){
        logger.debug("view eno===================== "+applyId);
        Apply apply = new Apply();
        try {
            apply =applyService.getApplyById(applyId);
            logger.debug("view eno===================== "+apply.getApplyId());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute(apply);
        return "appplyview";
    }

    @RequestMapping("/sys/apply/Controller/excel")
    public void excel_teacher_student_table(HttpServletResponse response )throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Apply> list =applyService.queryExcelInfo();
        System.out.println(list);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("学生报名表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("报名号");
        titleRow.createCell(1).setCellValue("项目ID");
        titleRow.createCell(2).setCellValue("学生ID");
        titleRow.createCell(3).setCellValue("学生姓名");


        //遍历将数据放到excel列中
        for (Apply apply : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(apply.getApplyId());
            dataRow.createCell(1).setCellValue(apply.getProjectId());
            dataRow.createCell(2).setCellValue(apply.getPersonId());
            dataRow.createCell(3).setCellValue(apply.getPersonName());
        }

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("项目学生报名名单".getBytes(),"iso-8859-1") + ".xls");

        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();

    }
}
