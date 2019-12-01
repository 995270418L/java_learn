package com.steve.algorithms.pass100;


/**
 * // 简单
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 
 *
 */
public class Question_14 {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 0 || strs == null){
            return "";
        }else if(strs.length == 1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int len = strs.length;
        int charLen = strs[0].length();
        int flag=0;
        while (flag < charLen){
            boolean append = false;
            char first = strs[0].charAt(flag);
            for(int i=1; i< len; i++){
                if(flag < strs[i].length() && strs[i].charAt(flag) == first){
                    append = true;
                }else{
                    append = false;
                    break;
                }
            }
            if(append) {
                sb.append(first);
            }else{
                break;
            }
            flag ++ ;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Question_14 q = new Question_14();
        String[] s = {"aa","a"};
        System.out.println(q.longestCommonPrefix(s));
    }

}
