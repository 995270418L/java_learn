package com.steve.ifeve.multipartline.lock.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 各种 map 示例
 */
public class MapDemo {

    public static void main(String[] args) {
        hashMapDemo();
    }

    /**
     * hash map 在高并发的情况下的空值问题
     */
    public static void hashMapDemo() {
        List<String> keyList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            keyList.add("key_" + i);
        }
        Map<String, String> map = new HashMap();
        map.put("a", "b");
        // 并发插入值
        keyList.parallelStream().forEach(e -> {
            map.put(e, e);
        });
        // 输出就会有空值了
        AtomicInteger count = new AtomicInteger();
        keyList.parallelStream().forEach(e -> {
            if (map.get(e) == null) {
                count.incrementAndGet();
                System.out.println("指定的key: " + e + ", 不存在");
            }
        });
        System.out.println(count.get());
    }

}
