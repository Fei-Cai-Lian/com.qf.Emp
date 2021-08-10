package com.qf.emp.controller;

import com.qf.emp.service.EmpService;
import com.qf.emp.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 员工的删除
 */
@WebServlet(name = "RemoveEmpController", value = "/manager/safe/removeEmpController")
public class RemoveEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id")) ;

        EmpService empService = new EmpServiceImpl() ;

        empService.removeEmp( id ) ;

        response.sendRedirect(request.getContextPath() +"/manager/safe/showAllEmpController");
    }
}
