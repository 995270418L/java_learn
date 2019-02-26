package com.steve.ifeve.multipartline.chapter12;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liu on 6/15/17.
 *  测试BoundedBuffer的生产者－消费者程序
 */
public class PutTakeTest {

    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private final AtomicInteger putSum = new AtomicInteger(0);
    private final AtomicInteger takeSum = new AtomicInteger(0);
    /**
     * 用来最大限度的使调度器执行并发测试，而不是由于单个线程执行时间较短而出现的串行执行程序
     */
    private final CyclicBarrier barrier;

    /**
     * 有边界的缓存，待测试对象
     */
    private final BoundedBuffer<Integer> bb;
    /**
     * 测试对象的个数，测试线程的的个数
     */
    private final int nTrials, nPairs;

    public PutTakeTest(int capacity, int nPairs, int nTrials){
        bb = new BoundedBuffer<>(capacity);
        this.nPairs = nPairs;
        this.nTrials = nTrials;
        // 初始值一般为测试线程总数　+ 1(主线程)
        // 测试线程总数 = 生产者线程总数　＋　消费者线程总数
        this.barrier = new CyclicBarrier(nPairs * 2 + 1);
    }

    void test(){
        try{
            for(int i=0; i < nPairs; i++){
                pool.execute(new Producer());
                pool.execute(new Customer());
            }
            //　等待所有线程就绪
            barrier.await();
            // 等待所有线程执行完成
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args){
        // 10000 次并发测试
        new PutTakeTest(10,10,10000).test();
        // 关闭线程池
        pool.shutdown();
    }

    class Producer implements Runnable{

        @Override
        public void run() {
            try{
                // 产生一个随机数
                int seed = this.hashCode() ^ (int)System.nanoTime();
                int sum = 0;
                // 等待线所有程准备
                barrier.await();
                for(int i = nTrials; i>0 ; i--){
                    bb.put(seed);
                    sum += seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    class Customer implements Runnable{
        @Override
        public void run() {
            try{
                barrier.await();
                int sum = 0;
                for(int i=nTrials ; i > 0; i --){
                    sum += bb.take();
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }

    public static int xorShift(int y){
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }
}
