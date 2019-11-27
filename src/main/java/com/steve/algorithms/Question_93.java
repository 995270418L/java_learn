package com.steve.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 */
public class Question_93 {

    private LinkedList<String> segements = new LinkedList<>();
    private List<String> res = new ArrayList<>();

    /**
     * DFS
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        if(s == null) return res;
        backtrace(-1, 3, s);
        return res;
    }

    public void backtrace(int prevPos, int dots, String s){
        int maxPos = Math.min(prevPos+4, s.length() - 1);
        for(int i = prevPos + 1; i< maxPos; i++){
            String segement = s.substring(prevPos+1, i+1);
            if(valid(segement)){
                segements.add(segement);
                if(dots - 1 == 0){
                    output(i, s);
                }else{
                    backtrace(i, dots-1, s);
                }
                segements.removeLast(); // 回溯
            }
        }
    }

    private void output(int index, String s){
        // 校验剩余
        String segement = s.substring(index+1);
        if(valid(segement)){
            segements.add(segement);
            res.add(String.join(".", segements));
            segements.removeLast();
        }
    }

    private boolean valid(String segment){
        int m = segment.length();
        if(m > 3)
            return false;
        return segment.charAt(0) != '0' ? Integer.valueOf(segment) <= 255 : m == 1;
    }


    public static void main(String[] args) {
        Question_93 question = new Question_93();
        String s = "25525511135";
        System.out.println(question.restoreIpAddresses(s));
    }

}
