package com.LiuYuhao.week6.demo;

import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        //start without /
        System.out.println("before redirect");
        response.sendRedirect("index.jsp");
        System.out.println("after redirect");
        //start with /
        response.sendRedirect("2019211001000911ZhangZhenbin_war_exploded/index.jsp");
*/

        //redirect - another server - Absolute url
        response.sendRedirect("https://www.baidu.com/");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}