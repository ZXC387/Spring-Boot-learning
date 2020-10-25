package com.zxc.springboot;

import com.zxc.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot 单元测试
 * 可以在测试期间类似编码一样进行自动注入等
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ac;

    @Test
    public void helloService() {
        boolean bean = ac.containsBean("helloService");
        System.out.println(bean);
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
