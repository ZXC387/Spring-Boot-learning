package com.zxc.springboot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *将配置文件中的配置的属性值映射到这个组件中
 * @ConfigurationProperties: 告诉SpringBoot将本类中的所有属性和配置文件相关的属性进行匹配
 * prefix：前缀 识别配置文件中哪个下面的属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 */
@ConfigurationProperties(prefix = "person")
@Component
@Data
public class Person {
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;

    private Dog dog;
}
