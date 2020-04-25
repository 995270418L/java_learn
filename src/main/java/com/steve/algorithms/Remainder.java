package com.steve.algorithms;

public class Remainder {

    public int remainder(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }

}
