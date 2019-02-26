package com.steve.framework.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundMethodInvoke implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("AROUND_ADVICE: around 开始");
        Object result = invocation.proceed();
        System.out.println("AROUND_ADVICE: around 结束");
        return result;
    }
}
