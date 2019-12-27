package com.steve.algorithms.pass200;

import io.netty.handler.codec.haproxy.HAProxyCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 *
 *
 * 示例：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 *
 */
public class Question_187 {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 10) return res;
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        while (index <= s.length() - 10){
            String temp = s.substring(index, index + 10);
            int value = map.getOrDefault(temp, 0);
            if(value == 1) res.add(temp);
            map.put(temp, value + 1);
            index ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Question_187 question = new Question_187();
        System.out.println(question.findRepeatedDnaSequences("AAAAAAAAAAAA"));
    }

}
