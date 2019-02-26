package com.steve.ifeve.Reflection.DynamicProxy;

import com.steve.ifeve.Reflection.DynamicProxy.interfaces.UserService;

/**
 * @Author: steve
 * @Date: Created in 8:37 2018/6/17
 * @Description:
 * @Modified By:
 */
public class UserServiceImpl implements UserService {

    @Override
    public String addUser() {
        System.out.println("增加用户成功");
        return "success";
    }

}
