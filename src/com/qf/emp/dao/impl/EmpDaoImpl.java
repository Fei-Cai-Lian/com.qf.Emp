package com.qf.emp.dao.impl;

import com.qf.emp.dao.EmpDao;
import com.qf.emp.entity.Emp;
import com.qf.emp.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
/**
 * 关于员工的
 */
public class EmpDaoImpl implements EmpDao {

    private QueryRunner queryRunner = new QueryRunner() ;

    @Override
    public List<Emp> selectAll() {
        try {
            List<Emp> emps = queryRunner.query(DbUtils.getConnection(),"select * from emp ;" , new BeanListHandler<Emp>(Emp.class)) ;
            return emps ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }
}
