package com.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/11/22.
 */
@Controller
public class Test {
    @Autowired
    ViewController viewController;
    @Autowired
    Test2 test2;
    @RequestMapping(value = "pass",method = RequestMethod.GET)
    public String test(){
        test2.test();
        return viewController.test();
    }
}
