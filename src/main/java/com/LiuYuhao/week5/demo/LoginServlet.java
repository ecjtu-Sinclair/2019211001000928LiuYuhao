package com.LiuYuhao.week5.demo;

import javax.servlet.*;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.*;
        import java.io.IOException;
        import java.io.OutputStream;
        import java.io.PrintWriter;
        import java.sql.*;
        import java.util.Objects;

@WebServlet (name="LoginServlet" , value="/Login")

public class LoginServlet extends HttpServlet {

    Connection con = null;
    String driver;
    String url;
    String username;
    String password;

    @Override
    public void init() throws ServletException {
        super.init();
/*        ServletContext context = getServletContext();
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
 */
        con= (Connection) getServletContext().getAttribute("con");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {

            Statement st = con.createStatement();
            String user = "select * from usertable where username=" + "'" + username + "'" + "and password='" + password + "'";
            ResultSet rs = st.executeQuery(user);
            if (rs.next()) {
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            } else {
                request.setAttribute("message","Username or Password Error!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

