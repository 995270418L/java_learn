package com.steve.designModule.VisitorModule.Classes;

import com.steve.designModule.VisitorModule.Interfaces.Visitor;

/**
 * Created by liu on 4/8/17.
 * financial department 财务部
 * 计算工资的
 */
public class FinacialDepartment implements Visitor {

    @Override
    public void visit(FullEmployees fullEmployees) {
        double hourWage = fullEmployees.getHourWage();
        int workTime = fullEmployees.getWorkTime();
        if(workTime >= 40){
            System.out.println(fullEmployees.getName() + "这周工作时间为:" + workTime + "。工资为:" + ((workTime-40)*100+hourWage));
        }else {
            System.out.println(fullEmployees.getName() + "这周工作时间为:" + workTime + "。工资为" + hourWage);
        }
    }

    @Override
    public void visit(PartTimeEmployees partTimeEmployees) {
        double hourWage = partTimeEmployees.getHourWage();
        int workTime = partTimeEmployees.getWorkTime();
        System.out.println(partTimeEmployees.getName() + "这周工作时间为:" + workTime + "。工资为"+ hourWage*workTime);
    }
}
