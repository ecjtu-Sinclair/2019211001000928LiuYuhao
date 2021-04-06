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
        System.out.println("i am in doGet()");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usertable where username=LiuYuhao and password=1234");
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("<table><tr><td>ID</td><td>UserName</td><td>Password</td><td>Email</td><td>Gender</td><td>BirthDate</td></tr>");
            while (rs.next()) {
                writer.print("<tr>");
                writer.print("<td>" + rs.getInt("id") + "</td>");
                writer.print("<td>" + rs.getString("username") + "</td>");
                writer.print("<td>" + rs.getString("password") + "</td>");
            }
            writer.print("</tr>");
            writer.print("</table>");
            writer.print("</body></html>");
            writer.close();
            if(){
                writer.println("Login Success!!!");
                writer.println("Welcome"+username);
                else{
                    writer.println("Username or Password Error!!!");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
