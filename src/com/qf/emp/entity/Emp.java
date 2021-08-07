package com.qf.emp.entity;
/**
 * 管理员所有有关的操作
 * 编写顺序：DbUtils 工具类
 * —— entity 实体类
 * —— dao 数据访问层接口-- dao 的 impl 数据访问层的实现类
 * —— service 业务层 的接口—— service的 接口的实现类
 * —— controller 的登录业务逻辑
 *
 * 这是一个新的实体类——————关于员工的
 */
public class Emp {
    private int id ;
    private String name ;
    private double salary ;
    private int age ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Emp() {
    }

    public Emp(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
