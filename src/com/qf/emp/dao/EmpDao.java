package com.qf.emp.dao;

import com.qf.emp.entity.Emp;

import java.util.List;
/**
 * 关于员工的
 */
public interface EmpDao {
    public List<Emp> selectAll() ;
}
