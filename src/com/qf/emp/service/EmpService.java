package com.qf.emp.service;

import com.qf.emp.entity.Emp;

import java.util.List;
/**
 * 关于员工的
 * 查询所有
 * 删除
 */
public interface EmpService {
    //查询所有
    public List<Emp> showAllEmp () ;
    //根据id做一个删除
    public int removeEmp(int id ) ;
    //修改
    public int modify(Emp emp );

    //查询一个
    public Emp showEmp(int id) ;
}
