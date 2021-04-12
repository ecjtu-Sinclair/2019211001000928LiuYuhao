package com.LiuYuhao.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/search")

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Text = request.getParameter("text");
        String Select = request.getParameter("search");
        //response.setContentType("text/html");
        if (Text.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            if (Select.equals("baidu")) {
                response.sendRedirect("https://www.baidu.com/s?wd=" + Text);
            } else if (Select.equals("bing")) {
                response.sendRedirect("https://cn.bing.com/search?q=" + Text);
            } else if (Select.equals("google")) {
                response.sendRedirect("https://www.google.com/search?q=" + Text);
            }

        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}