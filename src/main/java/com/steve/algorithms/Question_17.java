package com.steve.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 */
public class Question_17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        String[] lettleMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        // BFS 队列思路
        int len = digits.length();
        Queue<String> queue = new LinkedBlockingDeque<>();
        for(int i=0; i< lettleMap[digits.charAt(0) - '0'].length(); i++){
            queue.add(String.valueOf(lettleMap[digits.charAt(0) - '0'].charAt(i)));
        }
        for(int i=1; i< len; i++){
            int queueSize = queue.size();
            while(queueSize -- > 0){
                String characters = lettleMap[digits.charAt(i) - '0'];
                for(int j = 0; j<characters.length(); j++){
                    String s = queue.peek() + characters.charAt(j);
                    queue.add(s);
                }
                queue.poll();
            }
        }
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }

    /**
     * DFS 思路
     * @param digits
     * @return
     */
    public List<String> letterCombinationsDFS(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        backtrack(res, "", digits);
        return res;
    }

    /**
     * 一种DFS的遍历方法
     * @param result
     * @param combination
     * @param nextDigits
     */
    public void backtrack(List<String> result, String combination, String nextDigits){
        if(nextDigits.length() == 0){
            result.add(combination);
        }else{
            String[] lettleArr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            String digit = nextDigits.substring(0,1);
            String lettle =  lettleArr[digit.charAt(0) - '0'];
            for(int i=0; i< lettle.length(); i++){
                backtrack(result, combination + lettle.charAt(i), nextDigits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        Question_17 question = new Question_17();
        System.out.println(question.letterCombinationsDFS("23"));
    }

}
