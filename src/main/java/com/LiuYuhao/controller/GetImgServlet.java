package com.LiuYuhao.controller;

import com.LiuYuhao.dao.ProductDao;
import com.LiuYuhao.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GetImgServlet", value = "/GetImgServlet")
public class GetImgServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=0;
        if (request.getParameter("id")!=null)
            id=Integer.parseInt(request.getParameter("id"));
        ProductDao productDao=new ProductDao();
        Byte[] imgByte=new byte[0];
        try{
            imgByte=productDao.getPictureById(id,con);
            if (imgByte!=null){
                response.setContentType("image/gif");
                OutputStream out=response.getOutputStream();
                out.write(imgByte);
                out.flush();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
