package com.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/18.
 */
@Controller
public class FileUploadComtroller {

    @RequestMapping(value = "/uppage")
    public String uppage(){
        return "/uploadpage";
    }
    @RequestMapping(value ="upload")
    public String upload(@RequestParam("name") String name, @RequestParam("file")MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            file.transferTo(new File("E:\\"+file.getOriginalFilename()));
            return "redirect:/success.html";
        }else {
            return "redirect:/error.html";
        }
    }
    @RequestMapping(value = "success")
    public String success(){
        return "success";
    }
    @RequestMapping(value = "error")
    public String error(){
        return "error";
    }
}
