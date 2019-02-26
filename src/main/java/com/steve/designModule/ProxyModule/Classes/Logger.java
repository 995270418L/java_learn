package com.steve.designModule.ProxyModule.Classes;

import java.text.SimpleDateFormat;

/**
 * Created by liu on 4/1/17.
 * 日志记录类(代理过程中需要添加的内容) 代理模式关键类
 */
public class Logger{

    public void beforeMethod(String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(System.currentTimeMillis());
        System.out.println("方法: " +name + "() 被调用,调用时间为: "+time);
    }

    public void afterMethod(String name) {
        System.out.println("方法: "+ name + "() 调用成功");
    }

    public void afterMethodError(String name) {
        System.out.println("方法: " +name + "() 调用失败");
    }

}
