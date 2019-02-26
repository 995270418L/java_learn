package com.steve.cow_guest.classes.c3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: steve
 * @Date: Created in 19:51 2018/6/16
 * @Description: 用队列的数据结构表示栈
 * 思路： 用两个队列，一个是data，一个是help。插入数据往data里面插入，需要取数据时，将data中的数据保留一个，其余全部放入help队列。再颠倒data和help的引用即可。
 * @Modified By:
 */
public class TwoQueueToStack {
    private Queue<Integer> data = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(int value){
        data.add(value);
    }

    public int pop(){
        if(data.size() <= 0){
            throw new IllegalStateException("没有数据");
        }
        while(data.size() > 1){
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    public int peek(){
        if(data.size() <= 0){
            throw new IllegalStateException("没有数据");
        }
        while(data.size() > 1){
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap();
        return res;
    }

    // 交换引用
    private void swap() {
        Queue<Integer> tmp = data;
        data = help;
        help = tmp;
    }

    public static void main(String[] args) {
        TwoQueueToStack tt = new TwoQueueToStack();
        tt.push(1);
        tt.push(2);
        tt.push(3);
        System.out.println(tt.peek());
        System.out.println(tt.pop());
        System.out.println(tt.pop());
    }
}
