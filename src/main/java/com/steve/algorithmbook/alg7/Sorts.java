package com.steve.algorithmbook.alg7;

import java.util.Comparator;

/**
 * Created by liu on 11/15/16.
 * 各种排序方法大杂烩
 */
public class Sorts<T extends Comparable<? super T>>{

    //定义边界值
    private static final int CUTOFF = 3;

    /*
    * 待排序数组
    * */
    private static final Integer[] a = {4,3,4,4,4,5};

    public static <T extends Comparable<? super T>> void insertSort(T[] t){
        int j;
        for(int i=1;i<t.length;i++){
            T tmp = t[i];
            //降序排序
            for(j = i;j > 0 && tmp.compareTo(t[j-1])<0;j--)
                t[j] = t[j-1];
            t[j] = tmp;
        }
        for(T t1 : t){
            System.out.println(t1);
        }

    }

    public static <T extends Comparable<? super T>> void shellSort(T[] t){
        //希尔排序
        for(int gap = t.length/2; gap > 0; gap /= 2){
            int j;
            for(int i=gap; i < t.length; i++){
                T tmp = t[i];
                for(j = i; j>=gap && tmp.compareTo(t[j-gap])<0;j -= gap)
                    t[j] = t[j-gap];
                t[j] = tmp;
            }
        }
        for(T str : t){
            System.out.println(str);
        }

    }
    public static <T extends Comparator<? super T>> void output(T[] t){

        for(T str:t){
            System.out.println(str);
        }
    }

    //归并排序margeSort
    public static <T extends Comparable<? super T>> void  mergeSort(T[] t){
        T[] tmp = (T[]) new Comparable[t.length];
        mergeSort(t,tmp,0,a.length-1);
        for(T str : t){
            System.out.println(str);
        }
    }
    private static <T extends Comparable<? super T>> void mergeSort(T[] t,T[] tmp, int left,int right){
        if(left < right){
            int center = (left + right)/2;
            mergeSort(t,tmp,left,center);
            mergeSort(t,tmp,center+1,right);
            merge(t,tmp,left,center+1,right);
        }
    }

    /*
    * t: 待排序数组
    * tmp: 第三方数组
    * leftPos: 左数组起点
    * rightPos: 右数组起点
    * rightEnd: 第三方数组终点
    * */
    public static <T extends Comparable<? super T>> void merge(T[] t,T[] tmp,int leftPos,int rightPos,int rightEnd){
        int leftEnd = rightPos-1;
        int tmpPos = leftPos;
        //这不是初始的大小了，所以需要重新定义数组的大小
        int numElements = rightEnd - leftPos + 1;
        //main loop
        while(leftPos<=leftEnd && rightPos<=rightEnd){
            if(t[leftPos].compareTo(t[rightPos]) <0)
                tmp[tmpPos++] = t[leftPos++];
            if(t[leftPos].compareTo(t[rightPos]) >=0)
                tmp[tmpPos++] = t[rightPos++];
        }
        //当左边或者右边排完的时候,将剩余部分添加在第三方数组里面
        while(leftPos<=leftEnd)
            tmp[tmpPos++] = t[leftPos++];
        while(rightPos <= rightEnd)
            tmp[tmpPos++] = t[rightPos++];
        //将第三方数组里面的值赋予待排序的数组
        for(int i=0;i<numElements;i++,rightEnd--)
            t[rightEnd] = tmp[rightEnd];
    }

    //快排和插入排序结合（当元素的个数小于10个时使用插入排序）
    public static <T extends Comparable<? super T>> void quickSort(T[] t){
        quickSort(t,0,t.length-1);
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] t,int left,int right){
        if(left + CUTOFF <= right){
            T privor = media3(t,left,right);
            //start partitioning
            int i=left,j=right-1;
            for(;;){
                //从右边找个比它大的数的位置
                while(t[++i].compareTo(privor) < 0){}
                //从左边找个比它小的数的位置
                while(t[--j].compareTo(privor) > 0){}
                if(i<j){
                    swapReference(t,i,j);
                }else{
                    break;
                }
            }
            //退出循环时i==j
            swapReference(t,i,right-1);
            //左边
            quickSort(t,left,i-1);
            //右边
            quickSort(t,i+1,right);
        }else{
            insertSort(t);
        }
    }

    //三分中值法得到枢纽元pivor
    //排序他们，并返回hide枢纽元,why ??
    private static <T extends Comparable<? super T>> T media3(T[] t,int left,int right){
        int center = (left + right) / 2;
        if(t[center].compareTo(t[left]) < 0)
            swapReference(t,center,left);
        if(t[right].compareTo(t[left]) < 0)
            swapReference(t,right,left);
        if(t[right].compareTo(t[center]) < 0)
            swapReference(t,right,center);
        swapReference(t,center,right-1);
        return t[right-1];
    }

    public static <T extends Comparable<? super T>> void swapReference(T[] t,int index1,int index2){
        T tmp = t[index1];
        t[index1] = t[index2];
        t[index2] = tmp;
    }

    public static void main(String... args){
        Sorts.insertSort(a);
    }
}
