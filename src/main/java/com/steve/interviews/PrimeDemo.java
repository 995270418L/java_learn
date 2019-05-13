package com.steve.interviews;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Demo
 *
 * @author CuiShuai
 * @date 2019/2/21
 */
public class PrimeDemo {

    private static final Integer THREAD_NUM = Runtime.getRuntime().availableProcessors();
    //    public static AtomicInteger count = new AtomicInteger(0);
    public static final Integer END = 1000000;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Prime extends RecursiveTask<Integer> {

        private int start;
        private int end;
        private final static int THRESHOLD = 12;
//        private int threshold;

        @Override
        protected Integer compute() {
            int sum = 0;
            int num = start - end + 1;
            if (num >= 200) {
                List<Prime> primeList = new ArrayList<>();
                int divide = (num - 1) / THRESHOLD + 1;
                int start = 2;
                for(int i=0; i < divide; i++) {
                    Prime prime = new Prime();
                    prime.setStart(start);
                    start = start + THRESHOLD;
                    prime.setEnd(start - 1);
                    primeList.add(prime);
                }
                Prime prime = new Prime();
                prime.setStart(start);
                prime.setEnd(END);
                primeList.add(prime);
                Collection<Prime> primes = invokeAll(primeList);
                sum = primes.stream().mapToInt(prime1 -> {
                    try {
                        return prime1.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }).sum();
            } else {
                for(int i=start; i<= end; i++){
                    Boolean prime = true;
                    for(int j=2; j<= Math.sqrt(i); j++){
                        if(i % j == 0){
                            prime = false;
                            break;
                        }
                    }
                    if(prime){
                        System.out.println("prime: " + i);
                        sum ++;
                    }
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        Prime prime = new Prime(2, END);
        ForkJoinPool forkJoinPool =new ForkJoinPool(THREAD_NUM * 2);
        ForkJoinTask<Integer> result = forkJoinPool.submit(prime);
        long thisTimes = System.currentTimeMillis() - begin;
        System.out.println(String.format("素数个数: %s 耗时: %sms Threshold: %s", result.join(), thisTimes, Prime.THRESHOLD));
    }
}

