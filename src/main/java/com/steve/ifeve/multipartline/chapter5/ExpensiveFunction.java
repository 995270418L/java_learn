package com.steve.ifeve.multipartline.chapter5;

import com.steve.ifeve.multipartline.chapter5.interfaces.Computable;

import java.math.BigInteger;

/**
 * Created by liu on 5/13/17.
 * 不缓存每次都计算
 */
public class ExpensiveFunction implements Computable<String,BigInteger> {

    @Override
    public BigInteger compute(String args) throws InterruptedException {
        return new BigInteger(args);
    }
}
