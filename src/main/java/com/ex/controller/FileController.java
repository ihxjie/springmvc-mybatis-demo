package com.ex.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Calendar;

@Controller
public class FileController {

    Logger logger = LogManager.getLogger(FileController.class);

    @Resource
    ServletContext context;

    @PostMapping(value = "/fileUpload",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String fileUpload(@RequestParam("uploadFile") MultipartFile[] file, HttpServletRequest request) throws Exception {
        String path = "";
        for (MultipartFile multipartFile : file) {
            //判断文件是否为空
            if (!multipartFile.isEmpty()) {

                //获得原文件名
                String fileName = multipartFile.getOriginalFilename();
                String realPath = context.getRealPath("");
                path = "upload" + File.separator;
                Calendar ca = Calendar.getInstance();
                path += ("" + ca.get(Calendar.YEAR) + (ca.get(Calendar.MONTH) + 1) + ca.get(Calendar.DATE));
                //新建日期文件夹
                File dateDir = new File(realPath + path);
                if (!dateDir.exists()){
                    dateDir.mkdirs();
                }
                path += File.separator + System.currentTimeMillis() + "_" + fileName;
                // 复制本地文件到服务器
                FileCopyUtils.copy(multipartFile.getBytes(), new File(realPath + path));

            } else {
                logger.error("文件上传异常");
            }
        }
        return path;
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
}
