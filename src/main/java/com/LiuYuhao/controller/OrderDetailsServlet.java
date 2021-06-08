package com.LiuYuhao.controller;

import com.LiuYuhao.dao.OrderDao;
import com.LiuYuhao.model.Item;
import com.LiuYuhao.model.Order;
import org.apache.taglibs.standard.extra.spath.Step;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet", value = "/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy(){
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId=request.getParameter("orderId")!=null?Integer.parseInt(request.getParameter("orderId")):0;
        Item item=new Item();
        OrderDao orderDao=new OrderDao();
        List<Item> itemList= OrderDao.findItemsByOrderId(con,orderId);//get all items in an order
        request.setAttribute("itemList",itemList);
        String path="orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
