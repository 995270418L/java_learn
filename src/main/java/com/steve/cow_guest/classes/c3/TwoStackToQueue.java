package com.steve.cow_guest.classes.c3;

import java.util.Stack;

/**
 * @Author: steve
 * @Date: Created in 20:07 2018/6/16
 * @Description: 用栈结构实现队列操作
 * 思路： 两个栈，一个push，一个pop栈，，到要输出的时候，判断pop栈是否为空，为空，将push栈所有数据倒入pop栈，不为空，输出pop栈数据即可
 * @Modified By:
 */
public class TwoStackToQueue {
    private Stack<Integer> push = new Stack<>();
    private Stack<Integer> pop = new Stack<>();

    public void add(int value){
        push.push(value);
    }

    public int poll(){
        if(pop.isEmpty()){
            pushToPop();
        }
        if(pop.isEmpty()){
            throw new IllegalStateException("队列数据为空");
        }
        return pop.pop();
    }

    private void pushToPop() {
        if(!pop.isEmpty()){
            return;
        }
        while(!push.isEmpty()){
            pop.push(push.pop());
        }
    }

    public static void main(String[] args) {
        TwoStackToQueue tt = new TwoStackToQueue();
        tt.add(1);
        tt.add(2);
        tt.add(3);
        System.out.println(tt.poll());
        System.out.println(tt.poll());
        System.out.println(tt.poll());
        tt.add(2);
        tt.add(3);
        System.out.println(tt.poll());
        System.out.println(tt.poll());
    }
}
