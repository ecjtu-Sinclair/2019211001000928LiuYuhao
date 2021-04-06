package com.LiuYuhao.week5.demo;

import com.example.LiuYuhao2019211001000928.HelloServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();

        ServletContext context=getServletConfig().getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get parameter from request

        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        //response

        String x = null;
        String y = null;
        PrintWriter writer = response.getWriter();
        try {
            Statement stmt = con.createStatement();
            String User= "select * from userdb.dbo.usertable where username='LiuYuhao'and password='1234'";
            ResultSet rs = stmt.executeQuery(User);
            while(rs.next()) {
                x = rs.getString("username");
                y = rs.getString("password");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (Objects.equals(Username, x) && Objects.equals(Password, y)) {
            writer.println("Login Success!!!");
            writer.println("Welcome  " + x);
        } else {
            writer.println("Username or Password Error!!!");
        }


    }
}

