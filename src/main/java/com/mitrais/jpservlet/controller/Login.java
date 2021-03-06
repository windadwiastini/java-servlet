package com.mitrais.jpservlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("baseContext",req.getContextPath());
        String name = (String) req.getSession().getAttribute("name");
        if(name != null && !name.equals("")){ // sudah login
            resp.sendRedirect(req.getContextPath()+"/");
        }
        req.getRequestDispatcher("/login.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("baseContext",req.getContextPath());
        if(req.getParameter("username").equals("admin") && req.getParameter("password").equals("admin")){
            req.getSession().setAttribute("name",req.getParameter("username"));
            resp.sendRedirect(req.getContextPath()+"/");
        }
        else {
            req.setAttribute("error","Username or Password is wrong");
            req.getRequestDispatcher("/login.jsp").include(req, resp);
        }
    }
}
