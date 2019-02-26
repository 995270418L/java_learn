package com.steve.cow_guest.typical;

import java.util.Arrays;

/**
 * @Author: steve
 * @Date: Created in 8:51 2018/2/28
 * @Description: 对一个字符串数组进行升序排序，例如["de","abc"] --->> ["abc","de"] ;;; ["b","ba"] ---->> ["ba","b"]
 * @Modified By:
 */
public class StringSorted {

    public static void main(String[] args) {
        String[] source = {"b","ba"};
        Arrays.stream(sorted(source)).forEach(System.out::print);
    }

    /**
     * 对字符串数组进行升序排序，排序规则为 如果str1 + str2 < str2 + str1 则str1 < str2
     * @param source
     * @return
     */
    private static String[] sorted(String[] source) {
        String temp ;
        for(int i = 0; i<source.length; i++){
            for(int j = i; j<source.length-1 ; j++){
                if((source[j] + source[j+1]).compareTo(source[j+1]+source[j]) > 0){
                    temp = source[j];
                    source[j] = source[j+1];
                    source[j+1] = temp;
                }
            }
        }
        return source;
    }

    /**
     * 默认升序排序
     * @param source
     * @return
     */
    private static String[] sorted2(String[] source){
        Arrays.sort(source);
        return source;
    }
}
