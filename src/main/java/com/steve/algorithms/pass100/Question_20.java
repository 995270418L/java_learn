package com.steve.algorithms.pass100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *简单
 *
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 */
public class Question_20 {

    public boolean isValid(String s) {
        if(s == null || s.length() <= 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> src = new HashMap<>();
        src.put('(', ')');
        src.put('{', '}');
        src.put('[', ']');

        int len = s.length();
        if(src.get(s.charAt(0)) == null){
            return false;
        }
        stack.push(s.charAt(0));
        for(int i=1; i< len; i++){
            char tmp = s.charAt(i);
            if(src.get(tmp) != null){
               stack.push(tmp);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
               Character stackPop = stack.pop();
               if(src.get(stackPop) != tmp){
                   return false;
               }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Question_20 question = new Question_20();
        System.out.println(question.isValid("[]({}["));
    }

}
