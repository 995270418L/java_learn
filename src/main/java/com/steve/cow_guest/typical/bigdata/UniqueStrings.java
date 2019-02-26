package com.steve.cow_guest.typical.bigdata;

import java.util.BitSet;

/**
 * @Author: steve
 * @Date: Created in 17:52 2018/3/3
 * @Description: 大数据字符串去重
 * @Modified By:
 */
public class UniqueStrings {

    public static void main(String[] args) {
        String baidu = "https://www.baidu.com";
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        int hashCode = baidu.hashCode() & Integer.MAX_VALUE;
        bitSet.set(hashCode);
        // 统计着色位（value --> true）
        System.out.println(bitSet.cardinality());
        System.out.println(bitSet.get(hashCode));
    }

}
