package pdn.ac.lk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String method = request.getMethod();

        
        if (uri.contains("login") && method.equalsIgnoreCase("POST")) {
            System.out.println("[LOG] Login attempt detected at: " + new java.util.Date());
        } else if (uri.contains("register") && method.equalsIgnoreCase("POST")) {
            System.out.println("[LOG] Course registration attempt detected at: " + new java.util.Date());
        }
        
        return true; 
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }
}