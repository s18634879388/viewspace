package com.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/11/22.
 */
@Controller
public class ViewController {
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        return "hello";
    }
}
