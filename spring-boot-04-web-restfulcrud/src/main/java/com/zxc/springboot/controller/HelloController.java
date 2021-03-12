package com.zxc.springboot.controller;

import com.zxc.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ZXC
 * @create 2020-12-21 14:21
 */
@Controller
public class HelloController {

    @RequestMapping({"/","/login","/login.html"})
    public String index(){
        return "login";
    }


    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        System.out.println("外面"+user);
        if(user.equals("aaa")){
            System.out.println(user);
            throw new UserNotExistException();
        }
        return "success";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        //返回classpath:/templates/success.html页面
        map.put("users", Arrays.asList("张三","李四","王二"));
        map.put("hello","<h1>你好<h1>");
        return "success";
    }
}
