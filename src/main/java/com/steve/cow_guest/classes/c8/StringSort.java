package com.steve.cow_guest.classes.c8;

/**
 * 字符串子序列、全排列
 */
public class StringSort {

    // 全排列
    public static void solve(char[] str, int cur){
        if(cur == str.length){
            System.out.println(str);
        }
        for(int j = cur; j < str.length; j++){
            swap(str,cur,j);
            solve(str,cur + 1);
            swap(str,cur,j);
        }
    }

    public static void swap(char[] str,int start, int end){
        char tmp = str[start];
        str[start] = str[end];
        str[end] = tmp;
    }

    // 全部子序列
    public static void subSequenceSolve(char[] str, int cur, String res){
        if(cur == str.length){
            System.out.println(res);
            return ;
        }
        subSequenceSolve(str,cur + 1, str[cur] + res);
        subSequenceSolve(str,cur + 1, res);
    }

    public static void main(String[] args) {
//        subSequenceSolve("abc".toCharArray(),0,"");
        solve("qwertyuiopasdfghjklzxcvbnm".toCharArray(),0);
    }

}
