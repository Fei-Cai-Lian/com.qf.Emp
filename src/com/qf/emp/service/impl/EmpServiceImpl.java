package com.qf.emp.service.impl;

import com.qf.emp.dao.EmpDao;
import com.qf.emp.dao.impl.EmpDaoImpl;
import com.qf.emp.entity.Emp;
import com.qf.emp.service.EmpService;
import com.qf.emp.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于员工的
 */
public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl() ;
    @Override
    public List<Emp> showAllEmp() {
        List<Emp> emps = new ArrayList<>() ;
        try {
            DbUtils.begin();
            List<Emp> temps = empDao.selectAll();
            if(temps != null){
                emps = temps ;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emps;
    }
}
