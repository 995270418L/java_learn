package com.steve.cow_guest.typical;

/**
 * @Author: steve
 * @Date: Created in 20:59 2018/2/27
 * @Description: 不额外新建字符串对象的情况下 移动左侧指定位置的单词实现逆序。例如 str="ABCDE" i=2 移动后的结果为str="DEABC"
 * 解决思路:
 *      先对i位置以前的单词进行逆序(包括i)，再对i位置后的单词进行逆序排序。得到的结果再进行一次逆序，结果自然就是移动后的结果
 * @Modified By:
 */
public class MoveWord {

    public static void main(String[] args) {
        String source = "ABCDE";
        int i = 2;
        StringBuilder sb = new StringBuilder();
        sb.append(ReverseWord.reverse(source.substring(0,i+1)));
        sb.append(ReverseWord.reverse(source.substring(i+1)));
        String result = ReverseWord.reverse(sb.toString());
        System.out.println(result);
    }
}
