package com.qf.emp.controller;

import com.qf.emp.entity.EmpManager;
import com.qf.emp.service.EmpManagerServlet;
import com.qf.emp.service.impl.EmpManagerServletImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 管理员所有有关的操作
 * 编写顺序：DbUtils 工具类
 * —— entity 实体类
 * —— dao 数据访问层接口-- dao 的 impl 数据访问层的实现类
 * —— service 业务层 的接口—— service的 接口的实现类
 * —— controller 的登录业务逻辑
 */
@WebServlet(name = "EmpManagerLoginController", value = "/manager/EmpManagerLoginController")
public class EmpManagerLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、收参  账号 密码 验证码
        String username = request.getParameter("username") ;
        String password = request.getParameter("password") ;
        String inputVcode = request.getParameter("inputVcode") ;

        //2、校验验证码
        //请求. 作用域. 里面的验证码 强转为String 类型，并赋值给 String 类型的 codes
        String codes = (String) request.getSession().getAttribute("codes") ;

        if( ! inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)){    //对输入的验证码进行非空的判断 并且 与验证码的内容进行比较（不区分大小写）
            //调用业务逻辑，实现登录
            EmpManagerServlet empManagerServlet = new EmpManagerServletImpl() ;
            EmpManager empManager = empManagerServlet.login(username, password) ;
            //对 empManager 做非空判断
            if(empManager != null ){
                //登录成功
                //存储在session 中的作用域
                HttpSession session = request.getSession() ;
                session.setAttribute("empManager",empManager) ;
                //跳转到查询所有的controller——————因为没有临时数据，所以采用重定向
                response.sendRedirect( request.getContextPath() + "/manager/showAllEmpController") ;

            }else {
                //登录失败——打回登录页面——————因为没有临时数据，所以采用重定向
                response.sendRedirect(request.getContextPath()+"/login.html");
            }

        }else {
            //验证码输入错误，跳转到登录页面   跳转页面有两招——转发和重定向——————因为没有临时数据，所以采用重定向
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
    }
}
