package com.qf.emp.controller;

import com.qf.emp.entity.Emp;
import com.qf.emp.service.EmpService;
import com.qf.emp.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateEmpController", value = "/manager/safe/updateEmpController")
public class UpdateEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、收参
        Integer id = Integer.valueOf(request.getParameter("id")) ;
        String name = request.getParameter("name") ;
        Double salary = Double.valueOf(request.getParameter("salary")) ;
        Integer age = Integer.valueOf(request.getParameter("age")) ;

        //2、new 一个对象——有参构造方法实例化一个对象
        Emp emp = new Emp(id,name,salary,age) ;

        //3、调用Service 方法
        EmpService empService = new EmpServiceImpl() ;
        empService.modify( emp ) ;
        //4、查询
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmpController") ;
    }
}
