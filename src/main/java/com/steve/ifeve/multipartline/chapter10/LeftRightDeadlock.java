package com.steve.ifeve.multipartline.chapter10;

/**
 * Created by liu on 5/25/17.
 * 锁顺序死锁
 */
public class LeftRightDeadlock {

    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight(){
        synchronized(left){
            synchronized(right){
                // doSomething()
            }
        }
    }

    public void rightLeft(){
        synchronized(right){
            synchronized(left){
                //also do something here.
            }
        }
    }
}
