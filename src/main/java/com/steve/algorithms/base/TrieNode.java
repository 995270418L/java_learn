package com.steve.algorithms.base;

import lombok.Data;

/**
 * 前缀树实现
 */
@Data
public class TrieNode {

    public char val;
    public TrieNode[] nodes;

    public TrieNode(char val) {
        this.val = val;
        this.nodes = new TrieNode[26];  // 26个字母
    }

}
