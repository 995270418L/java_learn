package com.steve.designModule.VisitorModule.Classes;

import com.steve.designModule.VisitorModule.Abstracts.Employees;
import com.steve.designModule.VisitorModule.Interfaces.Visitor;

import java.util.ArrayList;

/**
 * Created by liu on 4/8/17.
 * 管理员工类 程序调用入口类
 */
public class EmployeesList {

    private ArrayList<Employees> list = new ArrayList<>();

    public void addEmployees(Employees employees){
        list.add(employees);
    }

    public void remove(Employees employees){
        list.remove(employees);
    }

    public void accept(Visitor visitor){

        for(Employees e : list){
            e.accept(visitor);
        }

    }
}
