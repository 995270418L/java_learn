package com.steve.cow_guest.classes.c2;

/**
 * @Author: steve
 * @Date: Created in 19:22 2018/6/14
 * @Description: 快速排序算法的两种实现
 * @Modified By:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = generator100();
        new QuickSort().quicksort(arr,0,arr.length-1);
        for(int i: arr){
            System.out.println(i);
        }
    }

    private static int[] generator100() {
        int[] a = new int[100];
        for(int i=0;i < a.length; i++ ){
            int tmp = (int) (Math.random()*100);
            a[i] = tmp;
        }
        return a ;
    }

    // 经典快排的实现，最后一个数当成基准数
    public void quicksort(int[] arr,int l,int r){
        if(l < r){
            int[] p = partition(arr,l,r);
            quicksort(arr,l,p[0]-1);
            quicksort(arr,p[1]+1,r);
        }
    }

    // 随机快排的实现，随机选择一个数当成比较的基准数
    public void quicksort2(int[] arr,int l, int r){
        if(l < r){
            int[] p = partition2(arr,l,r);
            quicksort(arr,l,p[0]-1);
            quicksort(arr,p[1]+1,r);
        }
    }

    private int[] partition2(int[] arr, int l, int r){
        int less = l-1;
        int more = r+1;
        int rp = (int) (Math.random()*(r-l));
        int tmp = arr[rp];
        while(l < more){
            if(arr[l] < tmp){
                swap(arr,++less,l++);
            }else if(arr[l] > tmp){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        return new int[]{less+1,more-1};
    }

    /**
     * 这里和荷兰国旗的分区差不多，只不过交换顺序有点差别而已。改进后的partition
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int[] partition(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);  // 这里需要将more区域的最小边界和标准值交换一下子。
        return new int[]{less+1,more};
    }

    private void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
