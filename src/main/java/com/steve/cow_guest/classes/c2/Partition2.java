package com.steve.cow_guest.classes.c2;

/**
 * @Author: steve
 * @Date: Created in 18:47 2018/6/14
 * @Description:
 * 给定一个数字数组arr和一个指定的数n,存在arr中部分数和n相等，要求将数组中的数小于指定数的放在数组左边，
 * 大于的放右边，时间复杂度O(N),空间复杂度O(1)  -------荷兰国旗问题
 * @Modified By:
 */
public class Partition2 {

    /**
     * 三个变量控制，一个是控制小于区域less,一个是当前遍历的指针cur，一个是控制大于n区域的more，
     *  当遇到的当前数比n小，就和less的下一个数交换，less++,cur++。
     *  当遇到的当前数和n相等，cur++;
     *  当遇到的数比n大，more--
     *  当more和cur相等时，就表示安排完毕。
     * @param arr
     * @param n
     */
    public void exchange(int[] arr,int n){
        int len = arr.length;
        int less = -1,tmp,more = len;
        for(int i=0;i<len;i++){
            if(more == i){
                break;
            }
            if(arr[i] < n){
                tmp = arr[i];
                arr[i] = arr[++less];
                arr[less] = tmp;
            }else if(arr[i] > n){
                tmp = arr[--more];
                arr[more] = arr[i];
                arr[i--] = tmp;
            }
        }
    }

    /**
     * 相对于exchange1方法改一下代码。
     * @param arr
     * @param l
     * @param r
     * @param n
     */
    public int[] exchange2(int[] arr,int l, int r, int n){
        int less = l-1;
        int more = r+1;
        int cur = l;
        while(cur < more){
            if(arr[cur] < n){
                swap(arr,cur++,++less);
            }else if(arr[cur] > n){
                swap(arr,--more,cur);
            }else{
                cur++;
            }
        }
        return new int[]{less+1,more-1};  // 增加返回值，返回等于区域的
    }

    private void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,4,2,5,5,8,1,7,5};
        new Partition2().exchange2(arr,0,arr.length-1,5);
        for(int i: arr){
            System.out.println(i);
        }
    }

}
