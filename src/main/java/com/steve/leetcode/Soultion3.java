package com.steve.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 */
public class Soultion3 {

    public static final String s = "abcabcdabcabcdbb";

    public static void main(String[] args) {
        System.out.println(solve2());
    }

    /**
     * 暴力枚举法
     */
    public static int solve(){
        Set<Character> tmp = new HashSet<>();
        int max = 0, i = 0, j = 0, n = s.length();
        // 滑动窗口
        /**
         * while 循环和 for 循环的区别在于， while 循环比较的是j的位置， 而for循环比较的是i的下一个位置
         */
        while(i < n && j < n){
            if(!tmp.contains(s.charAt(j))){
                tmp.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }else{
                tmp.remove(s.charAt(i++));  // 这里有重复的字符时，是逐渐的增加i，有点傻
            }
        }
        return max;
    }

    /**
     * 跳字符法，[i, j) 在s[j]中有重复字符 j' 时，i直接跳到 [i, j'] 后的 j' + 1的位置
     * @return
     */
    public static int solve2(){
        int n = s.length(),max = 0;
        Map<Character, Integer> tmp = new HashMap<>();
        for(int i=0, j =0; j< n; j++){
            if(tmp.containsKey(s.charAt(j))){
                i = Math.max(tmp.get(s.charAt(j)), i); // 为什么这里 i 也要和自己以前的值相比较? 因为这样可以确保 i 保持领先
            }
            max = Math.max(max, j - i + 1);
            tmp.put(s.charAt(j), j+1);
        }
        return max;
    }

}
