package com.steve.ifeve.Reflection.DynamicProxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: steve
 * @Date: Created in 8:38 2018/6/17
 * @Description:
 * @Modified By:
 */
public class ServiceInvokerHandler implements InvocationHandler{

    private Object target;

    public ServiceInvokerHandler(Object target) {
        this.target = target;
    }

    /**
     * 创建代理实例。
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        System.out.println("调用方法: " + method.getName() + " 开始");
        res = method.invoke(target,args);
        System.out.println("调用结束，结果为："+ res);
        return res;
    }
}
