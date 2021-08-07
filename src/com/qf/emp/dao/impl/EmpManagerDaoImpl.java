package com.qf.emp.dao.impl;

import com.qf.emp.dao.EmpManagerDao;
import com.qf.emp.entity.EmpManager;
import com.qf.emp.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 *  EmpManager 数据访问层的实现类——即 EmpManagerDao 的实现类
 *  编写顺序：DbUtils 工具类—— entity 实体类—— dao 数据访问层接口-- dao 的 impl 数据访问层的实现类
 */
public class EmpManagerDaoImpl implements EmpManagerDao {
    //用 QueryRunner 来执行 sql 语句
    private QueryRunner queryRunner = new QueryRunner() ;

    @Override
    public EmpManager select(String username) {
        try {
            //给一个数据库连接对象—— sql语句—— 封装成BeanHandler 泛型—— 参数为username
            EmpManager empManager = queryRunner.query(DbUtils.getConnection() , "select * from empmanager where username = ? ; ",new BeanHandler<EmpManager>(EmpManager.class) , username ) ;
            return empManager ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
