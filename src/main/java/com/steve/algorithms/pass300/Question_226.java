package com.steve.algorithms.pass300;


import com.steve.algorithms.base.TreeNode;

import java.util.*;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 */
public class Question_226 {

    public int calculate(String s) {
        // 中缀表达式转后缀表达式
        List<Character> list = infixToSuffix(s);
        return 0;
    }

    private List<Character> infixToSuffix(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('(', 3);
        map.put(')', 3);
        List<Character> res = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c != ' '){
                if( c >= '0' && c <= '9'){
                    res.add(c);
                }else{
                    int level = map.get(c);
                    while (map.get(stack.peek()) >= level){
                        res.add(stack.pop());
                    }
                    stack.push(c);
                    res.add(c);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question_226 question = new Question_226();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
//        t3.right = t7;

        System.out.println(question.calculate("3 + 2"));
    }

}
