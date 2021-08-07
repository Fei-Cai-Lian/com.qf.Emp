package com.qf.emp.controller;

import cn.dsna.util.images.ValidateCode;

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
 *
 * 生成验证码
 */
@WebServlet(name = "CreateCodeController", value = "/createCode")
public class CreateCodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过 4参方法 来对验证码图片进行设置               宽:200    高:20     输入字符:4    干扰线:20
        ValidateCode validateCode = new ValidateCode(200,30,4,20) ;

        //通过 validateCode.getCode()  获取需要输入字符的字符串  并用String 类型的 codes 进行接收
        String codes = validateCode.getCode() ;

        //获取 Session 作用域，并且通过 request.getSession() 来把验证码存储到作用域里
        HttpSession session = request.getSession() ;
        session.setAttribute("codes" ,codes ) ;

        //通过 validateCode.write(） 把验证码响应给客户端
        validateCode.write(response.getOutputStream());

    }
}
