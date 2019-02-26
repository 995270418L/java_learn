package com.steve.cow_guest.classes.c3;

/**
 * @Author: steve
 * @Date: Created in 19:37 2018/6/16
 * @Description: 用数组来实现栈数据结构，
 * 一个变量index，当添加一个数据时，index+1；当取出一个数据时，index-1.控制边界，很简单
 * @Modified By:
 */
public class ArrayStack {

    private int[] save = null;
    private int index; // 初始位置为0
    private int size;

    public ArrayStack(int size){
        this.size = size;
        save = new int[size];
    }

    public void push(int value){
        if(index >= size){
            throw new IllegalStateException("不能再往栈中添加数据了");
        }
        save[index++] = value; // 过加1
    }

    public int pop(){
        if(index <= 0){
            throw new IllegalStateException("栈中已经没有数据了");
        }
        return save[--index]; // 少减1，只要数组中有数据，index就不可能等于0
    }

    public int peek(){
        if(index <= 0){
            throw new IllegalStateException("栈中已经没有数据了");
        }
        return save[index-1];
    }

    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(3);
        as.push(1);
        as.push(2);
        as.push(3);
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        as.push(1);
        as.push(2);
        as.push(3);
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
    }
}
