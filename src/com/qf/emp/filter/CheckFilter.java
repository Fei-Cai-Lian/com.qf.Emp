package com.qf.emp.filter;

import com.qf.emp.entity.EmpManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤器包     权限验证
 */
@WebFilter(value = "/manager/safe/*")
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //向下转型 请求和响应，拆箱，强转
        HttpServletRequest request = (HttpServletRequest) servletRequest ;
        HttpServletResponse response = (HttpServletResponse) servletResponse ;

        HttpSession session = request.getSession() ;
        //在session作用域中获取登录拿到的对象
        EmpManager empManager = (EmpManager) session.getAttribute("empManager") ;

        //验证是否有登录过
        if(empManager != null){ //登录过
            filterChain.doFilter(request,response);
        }else {//没登录过
            //通过重定向—— 请求获取上下文路径的/login.html 使之跳转到到登陆页面
            response.sendRedirect(request.getContextPath()+"/login.html");

        }
    }

    @Override
    public void destroy() {

    }
}
