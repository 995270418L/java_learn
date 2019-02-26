package com.steve.algorithmbook.alg6;

/**
 * Created by liu on 11/12/16.
 * 堆的数据结构，数组实现
 */
public class Binaryheap<T extends Comparable<? super T>> {
    //数组默认的大小
    private static final int DEFAULT_SIZE = 10;
    //heap元素
    private T[] items;
    //heap里面的元素个数
    private int currentsize;
    public Binaryheap(){
        this(DEFAULT_SIZE);
    }
    public Binaryheap(int capacity){
        currentsize = 0;
        items = (T[]) new Comparable[ capacity+1 ];
    }
    public Binaryheap(T[] item){

    }
    //heap默认操作(插入和删除最小值的实现)
    public void insert(T t){
        //首先判断是否需要扩容
        if(currentsize == items.length -1)
            enlargeArray( items.length*2 +1);
        //上滤(percolate up)
        int hole = ++currentsize;
        for(;hole>1 && items[hole/2].compareTo(t)>0;hole /= 2){
            items[hole] = items[hole/2];
        }
        items[hole] = t;
    }
    public T deleteMin(){
        if(isEmpty()){
            throw new NullPointerException("没有元素在heap里面");
        }
        T x = items[currentsize--];
        items[1] = x;
        T tmp = x;
        int j;
        int i = 1;
        //下滤
        for(;i*2<=currentsize;i = j){
            j = i*2;
            if( j != currentsize && items[j+1].compareTo(items[j])<0)
                j++;
            //由于这里比较是需要分清左儿子还是右儿子的，需哦以需要引入j变量
            if(items[j].compareTo(x)<0)
                items[i] = items[j];
            else
                break;
        }
        items[i] = tmp;
        return findMin();
    }
    //扩大数组大小的方法
    public void enlargeArray(int newSize){
        T[] oldArray = items;
        items = (T[]) new Comparable[newSize];
        for(int i=0;i<oldArray.length;i++){
            items[i] = oldArray[i];
        }
    }
    //返回当前数组的大小
    public int size(){
        return this.currentsize;
    }
    //找寻最小值
    /*
    * 根据堆序性质:最小值一定是在根上面，所以最小值是array[1],0的位置是空的
    * */
    public T findMin(){
        return items[1];
    }
    public boolean isEmpty(){
        if(currentsize != 0)
            return false;
        return true;
    }
    public static void main(String... args){
        int numItems = 10000;
        Binaryheap<Integer> b = new Binaryheap<>();
        int i=37;
        for(;i!=0; i = (i+37) % numItems){
            b.insert(i);
        }
        for(i=1;i<numItems;i++){
            if(b.deleteMin() != i){
                System.out.println("OOPS! " + i);
            }
        }
    }
}
