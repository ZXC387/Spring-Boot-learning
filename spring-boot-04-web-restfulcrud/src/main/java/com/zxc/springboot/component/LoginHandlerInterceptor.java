package com.zxc.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZXC
 * @create 2021-01-17 17:02
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse response, Object o) throws Exception {
        Object username = req.getSession().getAttribute("loginUser");
        if(username==null){
            //未登录，返回登录页面
            //这里放入request域中，如果放入session域中则不显示
            req.setAttribute("msg","没有权限访问，请登录");
            req.getRequestDispatcher("/login.html").forward(req,response);
            return false;
        }else{
            //已登陆，放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
