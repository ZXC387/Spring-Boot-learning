package com.zxc.springboot.config;

import com.zxc.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ZXC
 * @create 2021-01-06 14:12
 */
//@EnableWebMvc
//使用WebMvcConfigurerAdapter,可以扩展SpringMVC的功能
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry)；
        //浏览器发送/zxc请求 来到success
        registry.addViewController("/zxc").setViewName("success");

    }
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean//将组件注册到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
//            //添加拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //SpringBoot已经做好静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/login.html","/","/user/login");
//            }


        };
        return adapter;
    }
    @Bean
    public LocaleResolver localeResolver(){
       return new MyLocaleResolver();
    }
}
