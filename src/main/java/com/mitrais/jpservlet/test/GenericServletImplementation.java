package com.mitrais.jpservlet.test;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/generic")
public class GenericServletImplementation extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter pw=servletResponse.getWriter();
        String name=servletRequest.getParameter("name");
        String province=servletRequest.getParameter("address");
        pw.println("Welcome "+ name+"<br/>");
        pw.println("From "+province);
    }
}
