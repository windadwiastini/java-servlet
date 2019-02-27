package com.mitrais.jpservlet.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "*")
public class CheckSession implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        String name = (String) httpReq.getSession().getAttribute("name");
        if(name != null && !name.equals("")){ // sudah login
            filter.doFilter(req, res);
        } else {
            httpReq.getRequestDispatcher("/login").forward(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
