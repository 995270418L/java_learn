package com.steve.algorithms.pass300;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 *
 */
public class Question_211 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] zeros = new int[numCourses];
        for(int[] cp : prerequisites) zeros[cp[0]] ++; // 这也是一种邻接链表的表示方法
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< numCourses; i++) if(zeros[i] == 0) queue.add(i);
        int[] res = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()){
            Integer pre = queue.poll();
            res[i] = pre;
            i ++;
            for(int[] cp : prerequisites){
                if (cp[1] == pre){
                    if(-- zeros[cp[0]] == 0) queue.add(cp[0]);
                }
            }
        }
        return i == numCourses ? res : new int[0];
    }

    public static void main(String[] args) {
        Question_211 question = new Question_211();
        System.out.println(question.findOrder(7, new int[][]{{2,3,1},{2,4,3}}));
    }

}
