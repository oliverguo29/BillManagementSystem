package com.ao.billms.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    // before call function
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object login_user = request.getSession().getAttribute("login_user");
        if(login_user!=null){
            // already login
            return true;
        }
        request.setAttribute("msg","please login");
        //forward to login page
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
