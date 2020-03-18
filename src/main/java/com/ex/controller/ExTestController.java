package com.ex.controller;

import com.ex.model.JSR303Test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
@RequestMapping("/test")
public class ExTestController {

    @Resource
    ServletContext context;


    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","hello");
        return "backstageSys";
    }

    @RequestMapping("/login")
    public String jsp(){
        return "login";
    }

    @RequestMapping("/fileUpload")
    public void fileUpload(@RequestParam("uploadFile")MultipartFile[] file, HttpServletRequest request) throws Exception {
        for (MultipartFile multipartFile : file) {
            //判断文件是否为空
            System.out.println("111");
            if (!multipartFile.isEmpty()) {

                //获得原文件名
                String fileName = multipartFile.getOriginalFilename();
                String uuid= UUID.randomUUID().toString().replace("-","");
                fileName = uuid + "_" + fileName;
                //File.separator表示在 UNIX 系统上，此字段的值为 /；在 Windows 系统上，它为 \，如：C:\tmp\test.txt和tmp/test.txt
                String filePath = context.getRealPath("") + "upload" + File.separator;
                //新建upload文件夹
                File upload = new File(filePath);
                if (!upload.exists()){
                    upload.mkdirs();
                }
                filePath += fileName;
                // 复制本地文件到服务器
                FileCopyUtils.copy(multipartFile.getBytes(), new File(filePath));

            } else {
                System.out.println("文件上传异常");
            }
        }
    }

    @RequestMapping("/fileDownload")
    public void fileDownload(@RequestParam(value="filename")String filename,HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filePath = request.getSession().getServletContext().getRealPath("upload") + File.separator +filename;
        //logger.info(filePath);
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        FileInputStream in = new FileInputStream(filePath);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = in.read(buffer)) > 0){
            out.write(buffer,0,len);
            out.flush();
        }
        out.close();
    }
    @RequestMapping(value = "/stu", method = RequestMethod.POST)
    public String saveStu(@Valid @ModelAttribute JSR303Test student, BindingResult result) {
        /*if something goes wrong during the project running*/
        if (result.hasErrors()) {
            System.out.println("there is some thing wrong!");
            for (FieldError error : result.getFieldErrors()) {
                System.out.println(error.getField() + " has problem:" + error.getDefaultMessage());
            }
            return "redirect:/";
        }
        return "redirect:/";
    }




}
