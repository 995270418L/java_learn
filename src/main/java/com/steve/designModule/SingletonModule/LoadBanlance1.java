package com.steve.designModule.SingletonModule;

import java.util.*;

/**
 * Created by liu on 3/26/17.
 * starve Singleton modeule
 * 服务器负载均衡软件
 */
public class LoadBanlance1 {

    public List<String> serverList = null;

    private LoadBanlance1(){
        serverList = new ArrayList();
    }

    //static final 类型的 LoadBanlance
    private final static LoadBanlance1 lb = new LoadBanlance1();

    public static LoadBanlance1 getInstance(){
        return lb;
    }

    public void addServer(String server){
        serverList.add(server);
    }

    public String getServer(){
        Random random = new Random();
        int index = random.nextInt(serverList.size());
        return serverList.get(index);
    }

    public void removeServer(String server){
        serverList.remove(server);
    }
}
