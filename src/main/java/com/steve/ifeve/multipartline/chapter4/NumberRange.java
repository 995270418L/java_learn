package com.steve.ifeve.multipartline.chapter4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liu on 5/5/17.
 * 都是线程安全的状态对象组合得到的类不一定是安全的
 */
public class NumberRange {
    /**
     * NumberRange 类的状态组成部分都是线程安全的。
     */
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    /**
     * 当多线程访问的时候，有可能 setLower(5)&&setUpper(4) 都执行成功.
     * 就不是线程安全的了
     */
    public void setLower(int i){
        if(i > upper.get()){
            throw new IllegalArgumentException(
                    "can't set lower to " + i + " > upper "
            );
        }
        lower.set(i);
    }

    public void setUpper(int i){
        if(i < lower.get()){
            throw new IllegalArgumentException(
                    "can't set upper to " + i + " < lower"
            );
        }
        upper.set(i);
    }

    public boolean isInRange(int i){
        return (i >= lower.get() && i <= upper.get());
    }

}
