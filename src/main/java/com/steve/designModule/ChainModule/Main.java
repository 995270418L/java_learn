package com.steve.designModule.ChainModule;

import com.steve.designModule.ChainModule.Abstracts.AbstractChain;
import com.steve.designModule.ChainModule.Classes.Director;
import com.steve.designModule.ChainModule.Classes.GeneralManager;
import com.steve.designModule.ChainModule.Classes.Leave;
import com.steve.designModule.ChainModule.Classes.Manager;

/**
 * Created by liu on 4/2/17.
 * 职责链模式
 *    Sunny软件公司的OA系统需要提供一个假条审批模块:如果员工请假天数小于3天,主任
 * 可以审批该假条;如果员工请假天数大于等于3天,小于10天,经理可以审批;如果员工
 * 请假天数大于等于10天,小于30天,总经理可以审批;如果超过30天,总经理也不能审
 * 批,提示相应的拒绝信息。试用职责链模式设计该假条审批模块。
 */
public class Main {

    public static void main(String... args){
        AbstractChain ac1,ac2,ac3;
        ac1 = new Director("wang");
        ac2 = new Manager("li");
        ac3 = new GeneralManager("liu");
        ac1.setAbstractChain(ac2);
        ac2.setAbstractChain(ac3);
        ac1.setLeave(new Leave("floder","感冒",2));
        ac1.setLeave(new Leave("mike","The world is big and I want to look around",7));
        ac1.setLeave(new Leave("toby","I have a serious illness",29));
        ac1.setLeave(new Leave("liu","This componey is not suit me",30));
    }
}
