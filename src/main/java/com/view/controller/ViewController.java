package com.view.controller;

import com.view.service.ViewService;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/11/22.
 */
@Controller
public class ViewController {
    @Autowired
    ViewService viewService;
    Logger logger = LoggerFactory.getLogger("com.view.controller.ViewController");
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        viewService.test();
        return "hello";
    }
    //日志
    @RequestMapping(value = "logtest",method = RequestMethod.GET)
    @ResponseBody
    public String logtest(){
        String name ="78787878";
        logger.info("info ==>  name = {}",name);
        logger.warn("warn ==>  name = {}",name);
        logger.debug("debug ==>  name = {}",name);
        logger.error("error ==>  name = {}",name);
        return "yes";
    }
}
