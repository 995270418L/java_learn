package com.steve.algorithms.repeat.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Question_17 {

    private static Map<Character, String> map = new HashMap();

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static void main(String[] args) {
        Question_17 question = new Question_17();
        int[] arr = {1, 2, 3};
        System.out.println(question.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        dfs(0, digits, "", res);
        return res;
    }

    public void dfs(int idx, String digits, String s, List<String> res) {
        if (idx == digits.length()) {
            res.add(s);
            return;
        }
        String letters = map.get(digits.charAt(idx));
        for (int i = 0; i < letters.length(); i++) {
            dfs(idx + 1, digits, s + letters.charAt(i), res);
        }
    }

}
