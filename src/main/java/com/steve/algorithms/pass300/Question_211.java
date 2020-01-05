package com.steve.algorithms.pass300;

import java.util.*;

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

    class TreeNode{

        private TreeNode[] links;
        private int R = 26;
        private Boolean isEnd;
        public TreeNode() {
            links = new TreeNode[R];
            isEnd = false;
        }
        public boolean containKey(char ch){
            return links[ch - 'a'] != null;
        }
        public void put(char ch, TreeNode treeNode){
            links[ch - 'a'] = treeNode;
        }
        public TreeNode get(char ch){
            return links[ch - 'a'];
        }
    }

    private TreeNode root;

    /** Initialize your data structure here. */
    public Question_211() {
        root = new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode temp = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TreeNode newNode = null;
            if(!temp.containKey(ch)){
                newNode = new TreeNode();
                temp.put(ch, newNode);
            }else{
                newNode = temp.get(ch);
            }
            temp = newNode;
        }
        temp.isEnd = true;
    }

    /**
     * 搜索的时候使用 DFS 吧
     * @param word
     * @return
     */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(TreeNode node, String word, int start){
        if(node == null) return false;
        if(start == word.length()) return node.isEnd;

        char ch = word.charAt(start);
        if(ch == '.'){
            TreeNode[] nodes = node.links;
            for(TreeNode tmp : nodes){
                if(dfs(tmp, word, start + 1)) return true;
            }
            return false;
        }else{
            if(!node.containKey(ch)) return false;
            node = node.get(ch);
            return dfs(node, word, start + 1);
        }
    }

    public static void main(String[] args) {
        Question_211 question = new Question_211();
        question.addWord("bad");
        question.addWord("dad");
        question.addWord("mad");
        System.out.println(question.search("pad"));
        System.out.println(question.search("bad"));
        System.out.println(question.search(".ad"));
        System.out.println(question.search("b.."));
    }

}
