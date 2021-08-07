package com.qf.emp.service.impl;

import com.qf.emp.dao.EmpManagerDao;
import com.qf.emp.dao.impl.EmpManagerDaoImpl;
import com.qf.emp.entity.EmpManager;
import com.qf.emp.service.EmpManagerServlet;
import com.qf.emp.utils.DbUtils;

/**
 * service的实现类
 * 编写顺序：DbUtils 工具类
 * —— entity 实体类
 * —— dao 数据访问层接口-- dao 的 impl 数据访问层的实现类
 * —— service 业务层 的接口—— service的 接口的实现类
 */
public class EmpManagerServletImpl implements EmpManagerServlet {

    private EmpManagerDao empManagerDao = new EmpManagerDaoImpl() ;

    @Override
    public EmpManager login(String username, String password) {
        //完成业务功能

        EmpManager empManager = null ;

        try {
            //开启事务
            DbUtils.begin();
            //通过empMangerDao 查询username 并存储在 EmpManager 对象的 temp 变量中
            EmpManager temp = empManagerDao.select(username) ;
            //判断账号密码
            if(temp != null){
                if(temp.getPassword().equals(password)){
                    //账号密码确认为正确
                    empManager = temp ;
                }
            }
            //提交事务
            DbUtils.commit();
        } catch (Exception e) {
            //事务回滚
            DbUtils.rollback();

            e.printStackTrace();
        }
        return empManager;
    }
}
