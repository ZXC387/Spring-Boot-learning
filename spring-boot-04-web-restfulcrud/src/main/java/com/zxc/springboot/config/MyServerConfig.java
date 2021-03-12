package com.zxc.springboot.config;

import com.zxc.springboot.filter.MyFilter;
import com.zxc.springboot.listener.MyListener;
import com.zxc.springboot.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author ZXC
 * @create 2021-01-21 10:59
 */
@Configuration //！！！！！标注配置类
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myFilter"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean MyListener(){
        ServletListenerRegistrationBean listener = new ServletListenerRegistrationBean();
        listener.setListener(new MyListener());
        return listener;
    }
    //配置嵌入式的servlet容器
    @Bean
    public EmbeddedServletContainerCustomizer customizer(){
        return new EmbeddedServletContainerCustomizer() {
            //定制嵌入式的servlet容器的相关规则
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8083);
            }
        };
    }
}
