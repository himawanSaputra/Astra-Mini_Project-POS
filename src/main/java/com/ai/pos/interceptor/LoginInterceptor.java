package com.ai.pos.interceptor;

import com.ai.pos.model.MstUser;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        MstUser user = (MstUser) session.getAttribute("user");
        if(user == null){
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
