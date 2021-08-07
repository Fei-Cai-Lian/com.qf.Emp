package com.qf.emp.controller;

import com.qf.emp.entity.Emp;
import com.qf.emp.service.EmpService;
import com.qf.emp.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllEmpController", value = "/manager/safe/showAllEmpController")
public class ShowAllEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在这里本来是要权限验证的   但是可以放到过滤器里去进行/manager/safe/showAllEmpController__safe以下的目录都是需要进行权限验证的

        EmpService empService = new EmpServiceImpl() ;
        List<Emp>emps = empService.showAllEmp() ;

        request.setAttribute("emps",emps);

        //通过转发的形式，把数据传输过去
        request.getRequestDispatcher("/manager/safe/showAllEmpJSP").forward(request,response);
    }
}
