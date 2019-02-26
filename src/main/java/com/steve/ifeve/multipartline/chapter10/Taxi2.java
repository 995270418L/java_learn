package com.steve.ifeve.multipartline.chapter10;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liu on 6/4/17.
 * 线程安全的Taxi and Dispatcher 类，是通过锁住关键部分来实现的，而不是整个方法
 */
@ThreadSafe
public class Taxi2 {
    @GuardedBy("this") private Point location, destination;
    @GuardedBy("this") private final Dispatcher2 dispatcher;

    public Taxi2(Dispatcher2 dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation(){
        return location;
    }

    public void setLocation(Point location){
        boolean reachedDestination;
        synchronized (this) {
            this.location = location;
            reachedDestination = location.equals(destination);
        }
        if(reachedDestination){
            dispatcher.notifyAvailable(this);
        }
    }
}

class Dispatcher2{
    @GuardedBy("this") private final Set<Taxi2> taxis;
    @GuardedBy("this") private final Set<Taxi2> availableTaxis;

    Dispatcher2() {
        this.taxis = new HashSet<>();
        this.availableTaxis = new HashSet<>();
    }

    public synchronized void notifyAvailable(Taxi2 taxi){
        availableTaxis.add(taxi);
    }
    // 地图上标记方法
}
