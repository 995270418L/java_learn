package com.steve.ml;

public class Main {

    public static void main(String[] args) {
        LinearRegression linearRegression = new LinearRegression("data",0.01,100);
        linearRegression.main();

        double []num = new double[4];
        num[0]=1.0;
        num[1]=4.0;
        num[2]=1.0;
        num[3]=2.0;
        linearRegression.test(num);
        System.exit(0);
    }
}
