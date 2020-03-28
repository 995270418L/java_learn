package com.steve.algorithms.recruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 最长公共子串
 */
public class Question_03 {

    /**
     * 暴力法就是全部都枚举出来，然后判断是否为 s2 的子串，这里使用滑动窗口来解决
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length() == 0) return true;
        if(s1.length() > s2.length()) return false;
        int[] num = new int[26];
        for(char c : s1.toCharArray()) num[c - 'a'] ++;
        int start = 0, end = s1.length() - 1;
        while (end < s2.length()){
            // 判断当前区间内存在不存在 s1 子串的排列
            boolean find = true;
            int[] tmp = new int[26];
            for(int i=start; i<=end; i++) tmp[s2.charAt(i) - 'a'] ++;
            for(int i=0; i<tmp.length; i++){
                if(tmp[i] != num[i]){
                    find = false;
                    break;
                }
            }
            if(find) return true;
            start ++;
            end ++;
        }
        return false;
    }

    /**
     * 和 1 一样，只不过这个实现的更优雅
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        if(s1 == null || s1.length() == 0) return true;
        if(s1.length() > s2.length()) return false;
        int[] num = new int[26];
        for(char c : s1.toCharArray()) num[c - 'a'] ++;
        int l = 0, r = 0;
        while (r < s2.length()){
            char c = s2.charAt(r ++);
            num[c - 'a'] --;
            while (l < r && num[c - 'a'] < 0){
                num[s2.charAt(l++) - 'a'] ++;
            }
            if((r - l) == s1.length()) return true;
        }
        return false;
    }


    /**
     * 全排列递归算法实现
     * @param word
     * @return
     */
    public List<String> permutation(String word){
        if(word == null || word.trim().length() <= 0) return null;
        int length = word.length();
        boolean[] used = new boolean[length];
        StringBuilder sb = new StringBuilder(length);
        List<String> res = new ArrayList<>();
        permutation(word, length, 0, sb, used, res);
        return res;
    }

    public void permutation(String word, int length, int position, StringBuilder buffer, boolean[] used, List<String> res){
        if(position == length){
            res.add(buffer.toString());
            return;
        }else{
            for(int i=0; i<length; i++){
                if(used[i]) continue;
                used[i] = true;
                buffer.append(word.charAt(i));
                permutation(word, length, position + 1, buffer, used, res);
                buffer.deleteCharAt(buffer.length() - 1);
                used[i] = false;
            }
        }
    }

    public Set<String> permutation2(String word){
        if(word == null || word.trim().length() <= 0) return null;
        Set<String> res = new TreeSet<>();
        permutation(0, word.toCharArray(), res);
        return res;
    }

    public void permutation(int index, char[] chars, Set<String> sets){
        if(index == chars.length - 1){
            sets.add(new String(chars));
            return ;
        }
        for(int i=index; i<chars.length; i++){
            swap(chars, i, index);
            permutation(index + 1, chars, sets);
            swap(chars, index, i);
        }
    }

    public void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        Question_03 question = new Question_03();
        String[] strs = {"flight", "flow", "flower"};
        System.out.println(question.checkInclusion("adc", "dcda"));
    }

}
