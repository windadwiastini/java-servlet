package com.mitrais.jpservlet.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "*")
public class CheckSession implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes= (HttpServletResponse) res;
        String loginURI = httpReq.getContextPath() + "/login";

        boolean isLoggedIn= httpReq.getSession().getAttribute("name")!=null && !httpReq.getSession().getAttribute("name").equals("");
        boolean loginRequest = httpReq.getRequestURI().equals(loginURI);

        if(isLoggedIn ||loginRequest){ // sudah login
            filter.doFilter(req, res);
        } else {
            httpRes.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {

    }
}
