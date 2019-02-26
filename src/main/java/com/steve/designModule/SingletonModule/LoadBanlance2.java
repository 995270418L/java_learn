package com.steve.designModule.SingletonModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by liu on 3/26/17.
 * 懒汉式加载LoadBanlance   (Lazy load module)
 */
public class LoadBanlance2 {

    public List<String> serverList = null;

    private LoadBanlance2(){
        serverList = new ArrayList<String>();
    }

    //使用volatile关键字
    private volatile static LoadBanlance2 lb2 = null;

    public static LoadBanlance2 getInstance(){
        if(lb2 == null){
            synchronized(LoadBanlance2.class){
                if(lb2 == null){
                    lb2 = new LoadBanlance2();
                }
            }
        }
        return lb2;
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
