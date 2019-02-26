package com.steve.ifeve.multipartline.chapter10;

import net.jcip.annotations.GuardedBy;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liu on 6/3/17.
 * 出租车和出租车车队循环调用引发死锁
 *  更新location的时候会出现循环调用 进而引发死锁。
 */
public class Taxi {
    @GuardedBy("this")
    private Point location, destination;
    private final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation(){
        return location;
    }

    public synchronized void serLocation(Point location){
        this.location = location;
        if(location.equals(destination)){
            dispatcher.notifyAvailable(this);
        }
    }
}

class Dispatcher{
    @GuardedBy("this") private final Set<Taxi> taxis;
    @GuardedBy("this") private final Set<Taxi> availableTaxi;

    Dispatcher() {
        this.taxis = new HashSet<>();
        this.availableTaxi = new HashSet<>();
    }

    public synchronized void notifyAvailable(Taxi taxi){
        availableTaxi.add(taxi);
    }

    public synchronized void getImage(){
        // 初始化画画
        // Image image = new Image();
        for(Taxi taxi : taxis){
            // 画画
        }
        // return image;
    }
}
