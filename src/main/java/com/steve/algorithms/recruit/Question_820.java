package com.steve.algorithms.recruit;

import com.steve.algorithms.base.Trie;

import java.util.Arrays;

/**
 *
 * 820. 单词的压缩编码
 *
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 */
public class Question_820 {

    /**
     * 时间复杂度： O(n^2) 空间复杂度: O(n)
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        if(words.length < 1) return 0;
        String res = words[0] + "#";
        for(int i=1; i<words.length; i++){
            res = contains(res, words[i]+"#");
        }
        return res.length();
    }

    public String contains(String src, String judge){
        if(src.contains(judge)){
            return src;
        }else if(judge.contains(src)){
            return judge;
        }else{
            return src + judge;
        }
    }

    public int minimumLengthEncoding2(String[] words) {
        if(words.length < 1) return 0;
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        Trie trie = new Trie();
        int res = 0;
        for(int i=0 ;i<words.length; i++){
            res += trie.insert(words[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Question_820 question = new Question_820();
//        System.out.println(question.contains("me#", "timd#"));
        int[] arr = {1,1};
        String[] words = {"time", "me", "bell"};
        System.out.println(question.minimumLengthEncoding2(words));
    }

}
