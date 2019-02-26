package com.steve.ifeve.multipartline.concurrentTools;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.FutureTask;

/**
 * @Author: steve
 * @Date: Created in 19:31 2018/3/16
 * @Description: Fork/Join 框架使用
 * @Modified By:
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        cancal2(1,1000000000);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end-start) + " ms");
    }

    public static void cancal(int start,int end){
        CountTask countTask = new CountTask(start,end);
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(countTask);
        try {
            System.out.println("最终结果为: " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void cancal2(int start, int end){
        int sum = 0;
        for(int i=start;i<=end;i++){
            sum += i;
        }
        System.out.println("最终结果: " + sum);
    }
}
