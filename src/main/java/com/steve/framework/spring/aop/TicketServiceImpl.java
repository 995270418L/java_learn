package com.steve.framework.spring.aop;

public class TicketServiceImpl implements TicketService {

    @Override
    public void sellTicket() {
        System.out.println("开始卖票");
    }

    @Override
    public void leftTicket() {
        System.out.println("查看系统剩余库存");
    }

}
