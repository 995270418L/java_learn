package com.steve.algorithms.repeat.recursive;


import java.util.HashMap;
import java.util.Map;

/**
 * 第K个语法符号
 *
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 */
public class KParams {

    /**
     * eg:
     *      0
     *      01
     *      0110
     *      01101001
     *
     * @param N [1, 30]
     * @param K [1, 2^(n - 1)]
     * @return
     */
    public int kthGrammar(int N, int K) {
        String res = helper(N, "0");
        return res.charAt(K-1) - '0';
    }

    public String helper(int N, String str){
        if(N == 1) return str;
        String res = "";
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == '0'){
                res += "01";
            }else{
                res += "10";
            }
        }
        return helper(N, res);
    }

    public int kthGrammar2(int N, int K){
        return Integer.bitCount(K - 1) % 2;
    }

    public static void main(String[] args) {
        KParams fibonacci = new KParams();
        System.out.println(fibonacci.kthGrammar2(30,434991989));
    }

}
