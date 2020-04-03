package com.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello/")
public class HelloTest {

    @ResponseBody
    @RequestMapping("test.do")
    public String test(){
        return "{\"code\":\"0000\",\"msg\":\"成功\"}";
    }
}
