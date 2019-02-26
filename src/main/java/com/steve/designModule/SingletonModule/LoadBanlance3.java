package com.steve.designModule.SingletonModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by liu on 3/26/17.
 * java中独有的IoDH　单例模式
 */
public class LoadBanlance3 {

    public List<String> serverList = null;
    private LoadBanlance3(){
        serverList = new ArrayList();
    }

    public static class HodlerClass{
        private static final LoadBanlance3 lb3 = new LoadBanlance3();
    }

    public static LoadBanlance3 getInstance(){
        return HodlerClass.lb3;
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
