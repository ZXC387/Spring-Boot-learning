package com.zxc.springboot.controller;

import com.zxc.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZXC
 * @create 2020-10-24 20:53
 */
//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@RestController
public class HelloController {

    @Value("${person.last-name}")//支持松散语法
    private String userName;
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello"+userName;
    }

}
