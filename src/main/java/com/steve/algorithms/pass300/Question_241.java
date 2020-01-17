package com.steve.algorithms.pass300;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 */
public class Question_241 {

    public Map<String, List<Integer>> map = new HashMap<>();

    /**
     * 自定而上的 dp
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<>();
        int len = input.length();
        for(int i=0; i< len; i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, len));
                for(int l : left){
                    for(int r : right){
                        switch (c){
                            case '+':
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(res.size() == 0) res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }


    public static void main(String[] args) {
        Question_241 question = new Question_241();
        int[][] src = new int[1][1];
        src[0][0] = 1;
        System.out.println(question.diffWaysToCompute("2-1-1"));
    }

}
