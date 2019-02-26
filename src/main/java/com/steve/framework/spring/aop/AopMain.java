package com.steve.framework.spring.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactoryBean;

public class AopMain {

    public static void main(String[] args) {
        Advice beforeAdvice = new BeforeMethodInvoke();
        Advice aroundAdvice = new AroundMethodInvoke();
        Advice throwsAdvice = new ThrowsMethodInvoke();
        Advice afterAdvice = new AfterMethodInvoke();

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();

        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        proxyFactoryBean.setInterfaces(TicketService.class);
        proxyFactoryBean.setTarget(ticketServiceImpl); // 目标代理对象
        proxyFactoryBean.addAdvice(afterAdvice);
        proxyFactoryBean.addAdvice(aroundAdvice);
        proxyFactoryBean.addAdvice(throwsAdvice);
        proxyFactoryBean.addAdvice(beforeAdvice);
        proxyFactoryBean.setProxyTargetClass(false);  // 默认 CGLIB 代理方式
        TicketService ticketService = (TicketService) proxyFactoryBean.getObject();
        ticketService.sellTicket();
    }
}
