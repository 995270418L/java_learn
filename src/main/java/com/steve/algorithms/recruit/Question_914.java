package com.steve.algorithms.recruit;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 914. 卡牌分组
 *
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *
 */
public class Question_914 {


    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if(len < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : deck){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int x=2; x<13; x ++){
            if(len < x || len % x != 0) continue;
            boolean find = true;
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                if(entry.getValue() % x != 0) {
                    find = false;
                    break;
                }
            }
            if(find) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Question_914 question = new Question_914();
        int[] arr = {1,1};
        System.out.println(question.hasGroupsSizeX(arr));
    }

}
