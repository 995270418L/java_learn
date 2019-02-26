package com.steve.designModule.VisitorModule.Classes;


import com.steve.designModule.VisitorModule.Abstracts.Employees;
import com.steve.designModule.VisitorModule.Interfaces.Visitor;

/**
 * Created by liu on 4/8/17.
 */
public class PartTimeEmployees extends Employees {

    private String name;
    private double hourWage;
    private int workTime;

    public PartTimeEmployees(String name,double hourWage,int workTime){
        this.name= name;
        this.hourWage = hourWage;
        this.workTime = workTime;
    }
    @Override
    public void accept(Visitor vistor) {
        vistor.visit(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourWage() {
        return hourWage;
    }

    public void setHourWage(double hourWage) {
        this.hourWage = hourWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}
