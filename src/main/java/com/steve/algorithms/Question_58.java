package com.steve.algorithms;


/**
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 *
 */
public class Question_58 {

    public int lengthOfLastWord(String s) {
        int len = 0;
        for(int j = s.length() - 1; j >= 0; j--){
            if(s.charAt(j) == ' ' && len == 0){
                continue;
            }else if(s.charAt(j) == ' '){
                break;
            }else{
                len ++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Question_58 question = new Question_58();
        System.out.println(question.lengthOfLastWord("b   a    "));
    }

}
