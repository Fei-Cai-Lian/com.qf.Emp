package com.qf.emp.dao;

import com.qf.emp.entity.EmpManager;

/**
 * DAO 数据访问层
 * 编写顺序：DbUtils 工具类—— entity 实体类—— dao 数据访问层接口
 */
public interface EmpManagerDao {
    //查询
    public EmpManager select(String username );
}
