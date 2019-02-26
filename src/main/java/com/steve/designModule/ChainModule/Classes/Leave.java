package com.steve.designModule.ChainModule.Classes;

/**
 * Created by liu on 4/2/17.
 * 请假dao
 */
public class Leave {

    private String name;  //请假员工姓名
    private String reason;  //请假原因
    private int time;   //请假多久

    public Leave(String name,String reason,int time){
        this.name = name;
        this.reason = reason;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
