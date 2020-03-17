package com.steve.algorithms.recruit;

/**
 *
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 */
public class Question_1160 {

    public int countCharacters(String[] words, String chars) {
        int[] wf = new int[26];
        for(int i=0; i< chars.length(); i++){
            char c = chars.charAt(i);
            wf[c - 'a'] += 1;
        }
        int res = 0;
        for(String word : words){
            int[] tmp = new int[26];
            boolean isOk = true;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                tmp[c - 'a'] += 1;
                if(tmp[c - 'a'] > wf[c - 'a']){
                    isOk = false;
                    break;
                }
            }
            if(isOk){
                res += word.length();
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Question_1160 question = new Question_1160();
        String[] arr = {"cat","bt","hat","tree"};
        System.out.println(question.countCharacters(arr, "atach"));
    }

}
