package com.steve.designModule.VisitorModule.Classes;

import com.steve.designModule.VisitorModule.Interfaces.Visitor;

/**
 * Created by liu on 4/8/17.
 * human source department
 * 计算工作时间
 */
public class HSDpartment implements Visitor {

    @Override
    public void visit(FullEmployees fullEmployees) {
        int workTime = fullEmployees.getWorkTime();
        if(workTime < 40){
            System.out.println(fullEmployees.getName() + "本周工作时间:"+workTime + "小时。请假时间:" +(40-workTime));
        }else if(workTime > 40){
            System.out.println(fullEmployees.getName() + "本周工作时间:"+workTime + "小时。加班时间:" + (workTime-40));
        }else if(workTime == 40){
            System.out.println(fullEmployees.getName() + "本周工作时间:" + workTime + "小时，正常完成任务");
        }else{
            System.out.println(fullEmployees.getName() + "请假一周");
        }
    }

    @Override
    public void visit(PartTimeEmployees partTimeEmployees) {
        int workTime = partTimeEmployees.getWorkTime();
        System.out.println(partTimeEmployees.getName() + "本周工作时间:" + workTime);
    }
}
