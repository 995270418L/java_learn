package com.steve.grammer;

/**
 * Created by liu on 3/13/17.
 * 从给定字符串中取出字符插入到新的字符串中，需要得到的字符串最小即可
 */
public class BestCowLine {

    static final int N = 6;

    static String s = "ACDBCB";

    public static void main(String... args){
        StringBuilder sb = new StringBuilder();
        char[] b = s.toCharArray();
        //反转字符串
        String rever_s = reverse(b);
        char[] c = rever_s.toCharArray();

    }

    public static String reverse(char[] b){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1 ; i >=0 ; i-- ){
            sb.append(b[i]);
        }
        return sb.toString();
    }

    //移除最末尾的那个字母,并返回移除的字符串
    public static String pop(String s){
        String result = s.substring(s.length()-1);
        s = s.substring(0,s.length()-2);
        return result;
    }

}
