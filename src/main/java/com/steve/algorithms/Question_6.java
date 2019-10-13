package com.steve.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 分析：
 *     字符索引从行0 至 行n，再从行n到行0， 反复至结尾
 */
public class Question_6 {

    public String convert(String s, int numRows) {
        if(numRows <= 1)
            return s;
        String[] res = new String[numRows];
        for(int i=0; i< numRows; i++){
            res[i] = "";
        }
        int i=0, flag = -1; // flag 的绝对值表示每次进位的长度， 符号表示方向
        for(char c : s.toCharArray()){
            res[i] += c;
            if(i == 0 || i == numRows - 1) flag = -flag; // 变换i改变的方向
            i += flag;
        }
        String result = "";
        for(String r : res){
            result += r;
        }
        return result;
    }

    public static void main(String[] args) {
        Question_6 q = new Question_6();
        System.out.println(q.convert("LEETCODEISHIRING", 3));
    }

}
