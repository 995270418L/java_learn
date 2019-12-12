package com.steve.algorithms.pass200;

import javafx.util.Pair;

import java.util.*;

/**
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 *
 */
public class Question_127 {

    /**
     * BFS 使用队列
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 先对 wordList 做预处理，构建无向图链表表示
        int len = beginWord.length();
        HashMap<String, List<String>> allowMap = new HashMap<>();
        for(String word: wordList){
            for(int i=0; i<len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> tempList = allowMap.getOrDefault(newWord, new ArrayList<>());
                tempList.add(word);
                allowMap.put(newWord, tempList);
            }
        }

        // 用来储存访问的节点
        Queue<Pair<String, Integer>> queue = new LinkedList();
        queue.add(new Pair<>(beginWord, 1));

        // 用来判断当前节点是否访问过
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()){
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            Integer level = pair.getValue();
            for(int i=0; i<len; i++){
                String newWord = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> relationWords = allowMap.getOrDefault(newWord, new ArrayList<>());
                for(String rWord : relationWords){
                    if(rWord.equals(endWord)) return level + 1;
                    if(!visited.containsKey(rWord)){
                        visited.put(rWord, true);
                        queue.add(new Pair<>(rWord, level+1));
                    }
                }
            }
        }
        return 0;
    }


    private HashMap<String, List<String>> allowMap = new HashMap<>();
    private int len;

    /**
     * 双向链表查找，一个从前面开始，一个从后面开始找
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthDouble(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        len = beginWord.length();

        for(String word: wordList){
            for(int i=0; i<len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> tempList = allowMap.getOrDefault(newWord, new ArrayList<>());
                tempList.add(word);
                allowMap.put(newWord, tempList);
            }
        }

        // 用来储存访问的节点
        Queue<Pair<String, Integer>> queueBegin = new LinkedList();
        queueBegin.add(new Pair<>(beginWord, 1));
        Queue<Pair<String, Integer>> queueEnd = new LinkedList();
        queueEnd.add(new Pair<>(endWord, 1));

        // 用来判断当前节点是否访问过
        HashMap<String, Integer> visitedBegin = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        HashMap<String, Integer> visitedEnd = new HashMap<>();
        visitedEnd.put(endWord, 1);

        while (!queueBegin.isEmpty() && !queueEnd.isEmpty()){
            int ans = encounter(queueBegin, visitedBegin, visitedEnd);
            if( ans > -1) return ans;
            ans = encounter(queueEnd, visitedEnd, visitedBegin);
            if( ans > -1) return ans;
        }
        return 0;
    }

    private int encounter(Queue<Pair<String, Integer>> queue, HashMap<String, Integer> visited, HashMap<String, Integer> otherVisited){
        Pair<String, Integer> pair = queue.poll();
        String word = pair.getKey();
        Integer level = pair.getValue();
        for(int i=0; i<len; i++){
            String newWord = word.substring(0, i) + "*" + word.substring(i+1);
            List<String> relationWords = allowMap.getOrDefault(newWord, new ArrayList<>());
            for(String rWord : relationWords){

                if(otherVisited.containsKey(rWord)){
                    return level + otherVisited.get(rWord);
                }

                if(!visited.containsKey(rWord)){
                    visited.put(rWord, level+1);
                    queue.add(new Pair<>(rWord, level+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Question_127 question = new Question_127();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        res.add(list3);
        res.add(list4);

        List<String> list = new ArrayList<>();
        // "hot","dot","dog","lot","log"
        list.add("log");
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
//        list.add("cog");
        System.out.println(question.ladderLengthDouble("hit","cog", list));
    }

}
