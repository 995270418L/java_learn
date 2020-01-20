package com.steve.algorithms.pass300;


import com.google.common.primitives.Chars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 简单：
 *
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
 * 有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 *
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 *
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 *
 * 示例 1:
 *
 * 输入: secret = "1807", guess = "7810"
 *
 * 输出: "1A3B"
 *
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 示例 2:
 *
 * 输入: secret = "1123", guess = "0111"
 *
 * 输出: "1A1B"
 *
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。  
 *
 */
public class Question_299 {

    public String getHint(String secret, String guess) {
        int countA = 0;
        int countB = 0;
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<secret.length(); i++){
            char src =  secret.charAt(i);
            char tar = guess.charAt(i);
            if(src == tar) {
                countA ++;
                continue;
            }
            list.add(tar);
            if(map.containsKey(src)){
                map.put(src, map.get(src) + 1);
            }else {
                map.put(src, 1);
            }
        }
        for(Character c : list){
            if(map.containsKey(c)){
                if(map.get(c) > 0) countB ++;
                map.put(c, map.get(c) - 1);
            }
        }
        return countA + "A" + countB + "B";
    }

    public static void main(String[] args) {
        Question_299 question = new Question_299();
        System.out.println(question.getHint("11","10"));
    }

}
