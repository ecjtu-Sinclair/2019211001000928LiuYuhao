package com.LiuYuhao.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name",value="LiuYuhao"),
                @WebInitParam(name="studentid",value="2019211001000928"),
        }
)
public class ConfigDemoServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getServletConfig().getInitParameter("name");
        String studentid = getServletConfig().getInitParameter("studentid");
        PrintWriter writer = response.getWriter();
        writer.println("Name:"+name);
        writer.println("StudentId:"+studentid);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
