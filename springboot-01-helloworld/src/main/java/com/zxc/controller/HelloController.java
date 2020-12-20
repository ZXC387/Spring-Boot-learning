package com.zxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zxc
 * @date 2019-03-10 10:56
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String Hello() {
        return "Hello world!!";
    }
}
