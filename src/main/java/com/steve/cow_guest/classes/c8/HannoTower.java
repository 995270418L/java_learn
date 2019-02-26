package com.steve.cow_guest.classes.c8;

/**
 * 汉诺塔，
 */
public class HannoTower {


    /**
     * 递归方法
     * @param N 表示需要移动的饼的总块数
     * @param from    起始柱子
     * @param to      目标柱子
     * @param help    中间柱子(又称帮助柱子)
     */
    public static void solve(int N, String from,String to,String help){
        if(N == 1){
            System.out.println("move 1 from " + from + " to: " + to);
        }else{
            // 首先移动N-1个饼从from到help柱子上
            solve(N-1,from, help, to);
            // 移动一个饼从from到to柱子上
            System.out.println("move " + N + " from: " + from + " to: " + to);
            // 移动N-1个饼从help到to柱子上，这就是一个典型的暴力搜索过程。
            solve(N-1, help, to ,from);
        }
    }

    public static void main(String[] args) {
        solve(3,"左","右","中");
    }
}
