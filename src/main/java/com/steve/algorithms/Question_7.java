package com.steve.algorithms;

/**
 * ** 简单 **
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 *  注意： 容易溢出，[ -2 ^ 32, 2^32 - 1]
 */
public class Question_7 {

    /**
     * 非常简单粗暴 但又是 非常有效的方法
     * @param x
     * @return
     */
    private int reverse(int x) {
        String s = String.valueOf(x);
        char lambel = 0;
        if(s.charAt(0) == '-' ){
            lambel = s.charAt(0);
        }
        int len = s.length();
        StringBuilder res = new StringBuilder();
        if(lambel > 0) {
            res.append(lambel);
            for(int i = 1; i < len ; i++){
                res.append(s.charAt(len - i));
            }
        }else{
            for(int i = 0; i < len ; i++){
                res.append(s.charAt(len - 1 - i));
            }
        }
        Integer result = 0;
        try {
            result = Integer.valueOf(res.toString());
        }catch (NumberFormatException e){

        }
        return result;
    }

    /**
     * 数字 pop 和 push 操作
     * pop = x % 10;
     * x = x / 10;
     *
     * push:
     * tmp = 0;
     * tmp = tmp * 10 + pop;
     *
     * @param x
     * @return
     */
    private int reverse2(int x) {
        int res=0, pop=0;
        while(x != 0){
            pop = x % 10;
            if(res >= Integer.MAX_VALUE / 10){
                if(( res == Integer.MAX_VALUE / 10 && pop > (Integer.MAX_VALUE - 1) % 10 ) || res > Integer.MAX_VALUE / 10){
                    return 0;
                }
            }else if(res <= Integer.MIN_VALUE / 10){
                if((res == Integer.MIN_VALUE / 10 && pop < (- Integer.MIN_VALUE % 10)) || res < Integer.MIN_VALUE / 10){
                    return 0;
                }
            }
            res = res * 10 + pop; // 可能发生溢出
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Question_7 q = new Question_7();
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(q.reverse2(-2147483648));
    }

}
