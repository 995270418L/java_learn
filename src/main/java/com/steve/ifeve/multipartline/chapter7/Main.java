package com.steve.ifeve.multipartline.chapter7;


import groovy.ui.SystemOutputInterceptor;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by liu on 5/16/17.
 */
public class Main {

    public static void main(String... args) throws InterruptedException {
        Main main = new Main();
        List<BigInteger> list = main.aSecondOfPrimes();
        for(final BigInteger bigInteger : list){
            System.out.println(bigInteger.toString());
        }
    }

    List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            Thread.sleep(1000);
        }finally{
            generator.calcel();  //finally 块确保sleep操作被中断也能继续运行
        }
        return generator.get();
    }
}
