package com.qf.emp.dao;

import com.qf.emp.entity.Emp;

import java.util.List;
/**
 * 关于员工的
 */
public interface EmpDao {
    //查询所有
    public List<Emp> selectAll() ;

    //删除——根据id
    public int delete( int id ) ;

    //修改
    public int update(Emp emp) ;

    //查询单个员工
    public Emp select(int id ) ;
}
