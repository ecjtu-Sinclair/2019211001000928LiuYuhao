package com.LiuYuhao.week3.demo;

import javafx.collections.ListChangeListener;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url="jdbc:sqlserver://localhost;databaseName=userdb;";
//        String username="sa";
//        String password="lyh3356485569";

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
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        String sql = "insert into userdb.usertable(id,username, password, email, gender , birthdate) values('0928','LiuYuhao','1234','3356485569@qq.com','male','2000-11-30');";
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("select * from usertable");
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("<table><tr><td>ID</td><td>UserName</td><td>Password</td><td>Email</td><td>Gender</td><td>BirthDate</td></tr>");
            while (rs.next()) {
                writer.print("<tr>");
                writer.print("<td>" + rs.getInt("id") + "</td>");
                writer.print("<td>" + rs.getString("username") + "</td>");
                writer.print("<td>" + rs.getString("paswword") + "</td>");
                writer.print("<td>" + rs.getString("email") + "</td>");
                writer.print("<td>" + rs.getString("gender") + "</td>");
                writer.print("<td>" + rs.getString("birthdate") + "</td>");
            }
            writer.print("</tr>");
            writer.print("</table>");
            writer.print("</body></html>");
            writer.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

//        writer.println("<br>username :"+username);
//        writer.println("<br>password :"+password);
//        writer.println("<br>Email :"+Email);
//        writer.println("<br>gender :"+gender);
//        writer.println("<br>birth Date :"+birthDate);
    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
