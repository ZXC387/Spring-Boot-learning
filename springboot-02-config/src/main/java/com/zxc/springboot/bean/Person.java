package com.zxc.springboot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中的配置的属性值映射到这个组件中
 *
 * @ConfigurationProperties: 告诉SpringBoot将本类中的所有属性和配置文件相关的属性进行匹配
 * prefix：前缀 识别配置文件中哪个下面的属性进行一一映射
 * 默认从全局配置文件中获取值
 * 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 * @PropertySource：从指定配置文件获取值
 */
//@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
@Component
@Data
//@Validated
public class Person {
    /**
     * @Value() 字面量
     * 可以写SpEL，#{}
     * 可以写${}，取出配置文件中的值 （在运行环境变量里面的值）
     */
    // @Email
    //@Value("${person.last-name}")
    private String lastName;
    // @Value("#{11+4}")
    private Integer age;
    //@Value("true")
    private Boolean boss;
    private Date birth;
    //@Value("person.maps")   这是错误的，@Value注解不支持复杂类型封装
    private Map<String, Object> maps;
    private List<Object> lists;

    private Dog dog;
}
