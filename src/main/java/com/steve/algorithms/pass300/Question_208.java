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
public class Question_208 {

    class TreeNode{
        public Character val; // 值（string）
        public Map<Character, TreeNode> map;
        public Boolean keyword; // 是否关键字
        public TreeNode(Character val, Boolean keyword){
            this.val = val;
            this.map = new HashMap<>();
            this.keyword = keyword;
        }
    }

    private TreeNode root = null;

    /** Initialize your data structure here. */
    public Question_208() {
        root = new TreeNode(null, true);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, TreeNode> map = root.map;
        TreeNode prev = null;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            boolean keyword = i == word.length() - 1;
            if(!map.containsKey(c)){
                TreeNode newNode = new TreeNode(c, keyword);
                map.put(c, newNode);
                if(prev != null) prev.map = map;
                prev = newNode;
                map = new HashMap<>();
                continue;
            }else{
                TreeNode treeNode = map.get(c);
                if(! treeNode.keyword) treeNode.keyword = keyword;
                prev = treeNode;
                map = treeNode.map;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Map<Character, TreeNode> map = root.map;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!map.containsKey(c)) return false;
            TreeNode treeNode = map.get(c);
            if(i == word.length() - 1) {
                return treeNode.keyword;
            }
            map = treeNode.map;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Map<Character, TreeNode> map = root.map;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!map.containsKey(c)) return false;
            TreeNode treeNode = map.get(c);
            map = treeNode.map;
        }
        return true;
    }


    public static void main(String[] args) {
        Question_208 trie = new Question_208();
        trie.insert("apple");

        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }

}
