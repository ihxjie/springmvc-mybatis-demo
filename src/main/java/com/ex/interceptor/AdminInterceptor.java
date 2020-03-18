package com.ex.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //String uri = request.getRequestURI();
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        if (username != null){
            return true;
        }
        request.setAttribute("info","您还没有登录，请先登录！");
        request.getRequestDispatcher("/WEB-INF/jsp/adminLogin.jsp").forward(request, response);
        return false;

    }
}
