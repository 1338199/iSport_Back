package com.judge.pose.controller;

import com.judge.pose.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;
    @RequestMapping("/upLoadImage")
    @ResponseBody

    void upLoadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        int exerciseId = Integer.parseInt(request.getParameter("exId"));
        String filename = request.getParameter("filename");
        String desc = request.getParameter("description");
        fileService.qiniuUpload(file, exerciseId, filename, desc);
    }

}
