package com.steve.cow_guest.classes.c3;

/**
 * @Author: steve
 * @Date: Created in 19:15 2018/6/16
 * @Description: 用数组结构实现队列(数组有固定大小)
 * 思路： 一个变量start记录存放值，每次存放start+1,一个变量end记录取值，每次存放end+1. 两者都从0开始。一个变量size存放当前容量是否超出，超出抛异常。
 *        当 start 或者 end 到达数组边界，需重置 start 和 end
 * @Modified By:
 */
public class ArrayQueue {

    private int[] save = null;
    private int start;
    private int end;
    private int arraySize;  //数组中有效数据的容量大小。
    private int size;

    public ArrayQueue(int size){
        this.size = size;
        save = new int[size];
    }

    public void add(int value){
        arraySize ++;
        if(arraySize > size){
            throw new IllegalStateException("容量超出限制");
        }
        save[start++] = value;
        start = start == save.length ? 0 : start;
    }

    public int remove(){
        if(arraySize <= 0){
            throw new IllegalStateException("数组中没有数据");
        }
        arraySize --;
        end = end == save.length ? 0 : end;
        return save[end++];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.remove());
    }

}
