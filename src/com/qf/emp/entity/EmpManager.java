package com.qf.emp.entity;

/**
 * 实体类——管理员登录
 * .编写顺序：DbUtils 工具类—— entity 实体类
 *  属性： private String username 、
 *          private String password
 *  方法：无参，
 *      有参，
 *      get and set ，
 *      toString
 */
public class EmpManager {
    private String username ;
    private String password ;

    public EmpManager() {
    }

    public EmpManager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmpManager{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
