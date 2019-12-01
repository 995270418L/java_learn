package com.steve.algorithms.pass100;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */
public class Question_67 {

    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while(m >=0 || n >= 0){
            int tm = m >= 0 ? a.charAt(m) - '0' : 0;
            int tn = n >= 0 ? b.charAt(n) - '0' : 0;
            int val = (tm + tn + flag) % 2;
            sb.append(val);
            flag = (tm + tn + flag) / 2;
            m --;
            n --;
        }
        if(flag != 0){
            sb.append(flag);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Question_67 question = new Question_67();
        System.out.println(question.addBinary("1010", "1011"));
    }

}
