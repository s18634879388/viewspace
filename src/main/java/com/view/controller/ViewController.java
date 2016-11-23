package com.view.controller;

import com.view.service.ViewService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/11/22.
 */
@Controller
public class ViewController {
    @Autowired
    ViewService viewService;
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        viewService.test();
        return "hello";
    }
}
