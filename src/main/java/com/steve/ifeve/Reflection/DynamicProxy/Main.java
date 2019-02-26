package com.steve.ifeve.Reflection.DynamicProxy;

import com.steve.ifeve.Reflection.DynamicProxy.handler.ServiceInvokerHandler;
import com.steve.ifeve.Reflection.DynamicProxy.interfaces.UserService;

/**
 * @Author: steve
 * @Date: Created in 8:36 2018/6/17
 * @Description:
 * @Modified By:
 */
public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ServiceInvokerHandler sih = new ServiceInvokerHandler(userService);
        UserService proxy = (UserService) sih.getProxy();
        proxy.addUser();
    }
}
