package com.steve.ifeve.multipartline;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 4/9/17.
 */
public class Main {

    public static void main(String... args) {
        Map<Integer, String> map = new HashMap<>(1);
        for (int i = 0; i < 20; i++) {
            map.put(i + 1, "name_" + i);
        }
    }

    /**
     * 随机数生成器
     *
     * @param y
     * @return
     */
    public static int xorShift(int y) {
        y ^= (y << 6);   // y = y ^ (y * 2^6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

}
