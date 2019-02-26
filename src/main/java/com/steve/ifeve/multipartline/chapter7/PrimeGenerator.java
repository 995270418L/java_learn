package com.steve.ifeve.multipartline.chapter7;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 5/16/17.
 * 素数生成器
 */
public class PrimeGenerator implements Runnable{

    private final List<BigInteger> primes = new ArrayList<>();

    private volatile boolean calcelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        BigInteger.probablePrime(1024,new SecureRandom());
        while(!calcelled){
            p = p.nextProbablePrime();
            synchronized(this){
                primes.add(p);
            }
        }
    }

    public void calcel(){
        calcelled = true ;
    }

    public synchronized List<BigInteger> get(){
        return new ArrayList<BigInteger>(primes);
    }
}
