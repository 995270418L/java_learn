package com.steve.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class Question_22 {

    public List<String> generateParenthesis(int n) {
        return null;
    }

    public List<String> generateViolence(int n){
        List<String> res = new ArrayList<>();
        char[] current = new char[2*n];
        recursiveGenerator(current, 0, res);
        return res;
    }

    public void recursiveGenerator(char[] current, int pos, List<String> res){
        if(pos == current.length){
            if(valid(current)){
                res.add(new String(current));
            }
        }else{
            current[pos] = '(';
            recursiveGenerator(current, pos + 1, res);
            current[pos] = ')';
            recursiveGenerator(current, pos + 1, res);
        }
    }

    public boolean valid(char[] current){
        int balabce = 0;
        for(char c: current){
            if(c == '('){
                balabce ++;
            }else{
                balabce --;
            }
            if(balabce < 0){return false;}
        }
        return balabce == 0 ;
    }

    public static void main(String[] args) {
        Question_22 question = new Question_22();
        System.out.println(question.generateViolence(3));
    }

}
