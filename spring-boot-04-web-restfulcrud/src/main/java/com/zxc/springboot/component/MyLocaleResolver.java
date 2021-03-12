package com.zxc.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author ZXC
 * @create 2021-01-16 19:32
 */
//自定义区域信息  http://localhost:8080/login.html?l=zh_CN
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest req) {
        String language = req.getParameter("l");
       Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(language)){
            //str[0]=zh  str[1]=CN
            String[] str = language.split("_");
            locale = new Locale(str[0],str[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
