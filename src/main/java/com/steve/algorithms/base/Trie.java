package com.steve.algorithms.base;

import lombok.Data;

@Data
public class Trie {

    private TrieNode root = new TrieNode('0');

    /**
     * 插入值
     * @param word
     * @return 插入的长度
     */
    public int insert(String word){
        if(word == null || word.trim().length() == 0) return 0;
        TrieNode[] nodes = root.nodes;
        boolean isNew = false;
        for(int i= word.length() - 1; i>=0; i--){
            char c = word.charAt(i);
            if(nodes[c - 'a'] == null){
                isNew = true;
               nodes[c - 'a'] = new TrieNode(c);
            }
            nodes = nodes[c - 'a'].nodes;
        }
        return isNew ? word.length() + 1 : 0;
    }

}
