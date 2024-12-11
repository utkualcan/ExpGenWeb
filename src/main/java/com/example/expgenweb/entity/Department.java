package com.example.expgenweb.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "deptno")
    private Integer deptno;

    @Column(name = "dname")
    private String dname;

    @Column(name = "loc")
    private String loc;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}