package com.steve.designModule.VisitorModule;

import com.steve.designModule.VisitorModule.Abstracts.Employees;
import com.steve.designModule.VisitorModule.Classes.*;
import com.steve.designModule.VisitorModule.Interfaces.Visitor;

/**
 * Created by liu on 4/8/17.
 * 访问者模式(人力资源部，财务部)
 */
public class Main {

    public static void main(String... args){
        Visitor v1,v2;
        v1 = new HSDpartment();
        v2 = new FinacialDepartment();
        Employees em1,em2;
        em1 = new FullEmployees("张无忌",3400.0,32);
        em2 = new PartTimeEmployees("段誉",2300,50);
        EmployeesList employeesList = new EmployeesList();
        employeesList.addEmployees(em1);
        employeesList.addEmployees(em2);
        employeesList.accept(v1);
        employeesList.accept(v2);
    }

}
