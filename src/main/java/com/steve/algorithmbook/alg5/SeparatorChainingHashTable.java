package com.steve.algorithmbook.alg5;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liu on 10/30/16.
 * 　分离链接法来解决散列值冲突问题
 *   传入的对象必须有hashCode这一方法
 */
public class SeparatorChainingHashTable<T extends Comparable<? super T>>{
    //散列主要是用来查找的所以最主要的三个方法是　contains remove insert,都是常数时间
    //主要应用hashTab hashSet

    //定义一个hashTable的大小
    private static final int DEFAULT_HASH_SIZE=101;

    //定义一个链表储存值
    private List<T>[] theList;

    private int currentSize;

    public SeparatorChainingHashTable(){
        this(DEFAULT_HASH_SIZE);
    }
    public SeparatorChainingHashTable(int size){
        //每个数组里面初始化一个链表
        theList = new LinkedList[nextPrime(size)];
        currentSize = theList.length;
        for(int i=0;i<theList.length;i++){
            theList[i] = new LinkedList<T>();
        }
    }

    public void insert(T t){
        List<T> whichList = theList[myHash(t)];
        if(!whichList.contains(t)){
            whichList.add(t);
            //如果大小超过table的大小，重新给这个表定义大小(肯定是素数)
            if(++currentSize > theList.length){
                rehash();
            }
        }
    }
    private void rehash(){
        List<T>[] oldList = theList;
        //扩充两倍大小并初始化List
        theList = new List[nextPrime(2*theList.length)];
        for(int j=0;j<theList.length;j++){
            theList[j] = new LinkedList<T>();
        }
        currentSize = 0;
        //copy 链表
        for(List<T> list : oldList){
            if(list != null){
                for(T item :list){
                    insert(item);
                }
            }
        }
    }
    public void remove(T t){
        List<T> whichList = theList[myHash(t)];
        if(whichList.contains(t)){
            whichList.remove(t);
            //size --
            currentSize --;
        }
    }
    public boolean contains(T t){
        List<T> whichList = theList[myHash(t)];
        return whichList.contains(t);
    }

    public int myHash(T t){
        int hash = t.hashCode();
        hash %= theList.length;
        if(hash<0){
            hash += theList.length;
        }
        return hash;
    }

    //找寻一个至少比n大的或者等于n的素数
    public static int nextPrime(int n){
        if(n%2 ==0)
            n++;
        for(;!isPrime(n);n+=2)
            ;
        return n;
    }

    //判断是否为素数
    public static boolean isPrime(int n){
        if(n==2 || n==3){
            return true;
        }
        if(n==1 || n%2 ==0){
            return false;
        }
        for(int i=3;i*i<n;i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String... args){
        SeparatorChainingHashTable<Integer> H = new SeparatorChainingHashTable<>();
        long startTime = System.currentTimeMillis( );
        final int NUMS = 2000000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            H.insert( i );
        for( int i = 1; i < NUMS; i+= 2 )
            H.remove( i );
        for( int i = 2; i < NUMS; i+=2 )
            if( !H.contains( i ) )
                System.out.println( "Find fails " + i );
        for( int i = 1; i < NUMS; i+=2 )
        {
            if( H.contains( i ) )
                System.out.println( "OOPS!!! " +  i  );
        }
        long endTime = System.currentTimeMillis( );
        System.out.println( "Elapsed time: " + (endTime - startTime) );
    }
}
