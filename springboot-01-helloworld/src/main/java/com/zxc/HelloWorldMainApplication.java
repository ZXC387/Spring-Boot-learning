package com.zxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zxc
 * @date 2019-03-10 10:27
 */
@SpringBootApplication //标注一个主程序类，说明这是一个 Spring Boot应用
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //Spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
