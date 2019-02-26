package com.steve.ifeve.multipartline.concurrentTools;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: steve
 * @Date: Created in 19:22 2018/3/16
 * @Description:
 * @Modified By:
 */
public class CountTask extends RecursiveTask<Integer> {

    private final int THRESHOLD = 2;
    private final int start;
    private final int end;

    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if((end - start) <= THRESHOLD){
            for(int i = start; i<=end; i++){
                sum += i;
            }
        }else{
            int mid = ( start + end ) / 2 ;
            CountTask leftTask = new CountTask(start,mid);
            CountTask rightTask = new CountTask(mid+1, end);

            // 划分任务
            leftTask.fork();
            rightTask.fork();

            // 得到结果
            sum =  leftTask.join() + rightTask.join();
        }
        return sum;
    }
}
