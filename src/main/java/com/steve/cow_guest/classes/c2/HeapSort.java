package com.steve.cow_guest.classes.c2;

import java.util.Arrays;

/**
 * @Author: steve
 * @Date: Created in 19:22 2018/6/15
 * @Description: 堆排序，堆：结构为完全二叉树，数据分两种，父节点数据比两个子节点大的叫大根堆，小的叫小根堆。
 * 从大到小排序思想：将数组中的数据进行heapInsert操作（构成大根堆），然后将heapSize中最后一个数和第一个数交换，heapSize-1，再将0—heapSize里的数据执行heapInsert操作建堆。再交换
 * 反过来就是从小到大排序。
 * @Modified By:
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] source = {6,2,7,3,1,2,3,4,4,1};
        new HeapSort().heapSort(source);
        for(int i: source){
            System.out.println(i);
        }
    }

    public void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        heapInsert(arr);
        int heapSize = arr.length;
        // 初次交换
        swap(arr,0,--heapSize);
        while (heapSize >0 ){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    // 微调，当大根堆中某个数变化时整个大根堆的调整。这里是第一个数
    private void heapify(int[] arr,int index, int heapSize) {
        int left = 2 * index +1; // 左儿子，有可能只有一个儿子存在。
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left+1] > arr[left]
                    ? left+1
                    : left;
            largest = arr[index] > arr[largest] ? index: largest;
            if(largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = 2 * index +1;
        }
    }

    // 构建大根堆，每个节点和它的父节点比较 (i-1/2) 时间复杂度: N*LogN
    private void heapInsert(int[] arr) {
        for(int i=0;i<arr.length;i++){
            while(arr[i] > arr[(i-1)/2]){
                swap(arr,i,(i-1)/2);
                i = (i-1)/2;
            }
        }
    }

    private void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
