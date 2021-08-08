package com.qf.emp.jsp;

import com.qf.emp.entity.Emp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllEmpJSP", value = "/manager/safe/showAllEmpJSP")
public class ShowAllEmpJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为是查询所有，故涉及到临时数据
        //1、获取集合数据
        List<Emp> emps = (List<Emp>) request.getAttribute("emps") ;
            //乱码的处理 丢到了过滤器里了————filter 包下的 EncodingFilter
            //获取一个字节输出流
        PrintWriter printWriter = response.getWriter() ;

        //编辑网页
        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>查询所有员工页面</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <table border='1'>");
        printWriter.println("           <tr>");
        printWriter.println("               <td>编号</td>");
        printWriter.println("               <td>姓名</td>");
        printWriter.println("               <td>工资</td>");
        printWriter.println("               <td>年龄</td>");
        printWriter.println("               <td colspan='2'>操作</td>");
        printWriter.println("           </tr>");
        for(Emp emp: emps){
            printWriter.println("           <tr>");
            printWriter.println("               <td>"+emp.getId()+"</td>");
            printWriter.println("               <td>"+emp.getName()+"</td>");
            printWriter.println("               <td>"+emp.getSalary()+"</td>");
            printWriter.println("               <td>"+emp.getAge()+"</td>");
            printWriter.println("               <td><a href='"+request.getContextPath()+"/manager/safe/removeEmpController?id="+emp.getId()+"'>删除<a></td>");
            printWriter.println("               <td><a href='"+request.getContextPath()+"/manager/safe/showEmpController?id="+emp.getId()+"'>修改</a></td>");
            printWriter.println("           </tr>");
        }
        printWriter.println("       </table>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

}
