package com.LiuYuhao.controller;

import com.LiuYuhao.dao.UserDao;
import com.LiuYuhao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    Connection con=null;
    private Object UserDao;
    private Date birthdate;

    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/UpdateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get parameters
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");

        try {
            birthdate = df.parse(""+request.getParameter("birthdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //ToDo creat an object of User model
        //TODo set all 6 request parameter values into User model
        User user=new User(id,username,password,email,gender,birthdate);

        //ToDo creat an object of UserDao
        com.LiuYuhao.dao.UserDao userDao= new UserDao();
        //ToDO call UpdateUser() in UserDao
        try {

            UserDao = userDao.updateUser(con,user);

            //forward to WEB-INF/Views/userInfo.jsp
            //reLogin-->use new password
            request.getRequestDispatcher("/Login").forward(request,response);
            // request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
