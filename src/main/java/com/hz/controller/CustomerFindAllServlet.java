package com.hz.controller;

import com.hz.daomain.Customer;
import com.hz.services.CustomerServices;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class CustomerFindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();
        //spring提供一个获取web容器的工具类
        //获取spring容器对象，将其存入ServletContext中
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        CustomerServices service=context.getBean("customerServicesImpl", CustomerServices.class);
        List<Customer> customers = service.findAllCustomer();
//        for (Customer c :
//                costumers) {
//            System.out.println(c);
//        }
//        System.out.println("ok");
        request.setAttribute("list",customers);
        request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
        System.out.println("ok");
    }
}
