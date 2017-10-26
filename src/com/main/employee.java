/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;

/**
 *
 * @author VI391762
 */
public class employee {
    private int empid;
    private String ename;

    public int getEmpid() {
        return empid;
    }

    @Override
    public String toString() {
        return "employee{" + "empid=" + empid + ", ename=" + ename + '}';
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
    
    
}
