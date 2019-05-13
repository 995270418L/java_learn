package com.steve.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 最长字符串的子串长度
 */
public class UniqueString {

    public static final String S = "ABCABADC";

    public static void main(String[] args) {
        UniqueString uniqueString = new UniqueString();
//        uniqueString.slideWindows();
//        uniqueString.violence();
        uniqueString.optimizeSlideWindow();
    }

    /**
     * 暴力枚举法
     */
    public void violence(){
        String result = null;
        int max = 0;
        for(int i=0; i<S.length(); i++){
            for(int j=i+1; j<=S.length(); j++){
                if(allUnique(i, j)){
                    if( (j-i) > max){
                        max = j -i;
                        result = S.substring(i,j);
                    }
                }else{
                    break;
                }
            }
        }
        System.out.println("最长字串为: " + result);
    }

    /**
     * 判断这个字符串是否不包含重复字符
     * @return
     */
    public boolean allUnique(int start, int end){
        Set<Character> characters = new HashSet<>();
        for(; start < end; start ++){
            if(!characters.contains(S.charAt(start))){
                characters.add(S.charAt(start));
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 滑动窗口法（数据和列表某一长度范围内的数据即窗口）
     */
    public void slideWindows(){
        Set<Character> chars = new HashSet<>();
        String result = null;
        int i =0 , j =0, max = 0;
        while( i < S.length() && j < S.length()){
            if(!chars.contains(S.charAt(j))){
                chars.add(S.charAt(j++));
                if((j - i) > max){
                    max = j -i;
                    result = S.substring(i,j);
                }
            }else{
                chars.remove(S.charAt(i++));
            }
        }
        System.out.println("最长字串为: " + result);
    }

    public void optimizeSlideWindow(){
        LinkedHashMap<Character, Integer> map = new LinkedHashMap();
        int max = 0, i=0, j=0;
        // 这种解法不属于滑动窗口
//        for(int i=0; i< S.length(); i++){
//            if(!map.containsKey(S.charAt(i))){
//                map.put(S.charAt(i), i);
//            }else{
//               Integer j = map.get(S.charAt(i));
//               if(max < map.size()){
//                   max = map.size();
//               }
//               i = j;
//               map.clear();
//            }
//        }
//        if(!map.isEmpty()){
//            max = Math.max(max, map.size());
//        }

        while(j < S.length() && i < S.length()){
            if(map.containsKey(S.charAt(j))){
                i = map.get(S.charAt(j)) + 1;
            }
            max = Math.max(max, j - i + 1);
            map.put(S.charAt(j), j+1);
            j++;
        }

        System.out.println("max length: " + max);
    }

}