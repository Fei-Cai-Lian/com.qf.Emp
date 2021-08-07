package com.qf.emp.service;

import com.qf.emp.entity.EmpManager;

/**
 * 业务层 接口
 * 编写顺序：DbUtils 工具类—— entity 实体类—— dao 数据访问层接口-- dao 的 impl 数据访问层的实现类—— service 业务层 的接口
 */
public interface EmpManagerServlet {
    public EmpManager login( String username , String password ) ;

}
