package com.ex.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String Email = String.valueOf(session.getAttribute("email"));
        System.out.println("*****" + Email);
       if(Email.equals("游客")){
           System.out.println("1231231");
           request.getRequestDispatcher("/WEB-INF/views/404.jsp").forward(request,response);
       }
       return true;


    }
}
