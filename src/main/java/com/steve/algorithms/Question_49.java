package com.steve.algorithms;


import java.util.*;

/**
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 */
public class Question_49 {

    /**
     * 最简单的写法，借用 HashMap, 感觉有问题
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i ++){
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                List<String> tList = new ArrayList<>();
                tList.add(strs[i]);
                map.put(key, tList);
            }
        }
        res.addAll(map.values());
        return res;
    }

    //
    public boolean isEquals(String[] strs){
        for(int i=0; i< strs.length; i++){
            int strILen = strs[i].length();
            for(int j=i+1; j< strs.length; j++){
                if(strILen != strs[j].length()){
                    return false;
                }
                for(int k=0; k<strILen; k++){
                    if(strs[j].indexOf(strs[i].charAt(k)) == -1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question_49 question = new Question_49();
        System.out.println(question.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
