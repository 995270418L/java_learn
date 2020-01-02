package com.steve.algorithms.pass300;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 */
public class Question_208_2 {

    /**
     * 前缀树实现
     */
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

    private TreeNode root = null;

    /** Initialize your data structure here. */
    public Question_208_2() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode tmp = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!tmp.containKey(ch)){
                tmp.put(ch, new TreeNode());
            }
            tmp = tmp.get(ch);
        }
        tmp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    private TreeNode searchPrefix(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }


    public static void main(String[] args) {
        Question_208_2 trie = new Question_208_2();
        trie.insert("apple");

        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }

}
