package com.steve.algorithms.repeat.recursive;

public class ReverseStr {

    public void printStr(char[] str){
        printStrIdx(0, str);
    }

    public void printStrIdx(int index, char[] str){
        if(index >= str.length){
            return ;
        }
        printStrIdx(index + 1, str);
        System.out.println(str[index]);
    }

    public void reverseString(char[] s) {
        reverStrHelper(s, 0, s.length - 1);
        for(char i : s){
            System.out.println(i);
        }
    }

    public void reverStrHelper(char[] s, int i, int j){
        if(i >= j) return;
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        reverStrHelper(s, i+1, j-1);
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        char[] src = {'a','b','c','d'};
        reverseStr.reverseString(src);
    }
}
