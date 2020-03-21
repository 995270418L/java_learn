package com.steve.algorithms.recruit;

import javafx.util.Pair;

import java.util.*;

/**
 *
 * 365. 水壶问题
 *
 */
public class Question_365 {

    /**
     * BFS 的解法
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWaterBFS(int x, int y, int z) {
        if( x + y < z) return false;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            Integer sum = queue.poll();
            // 倒入X
            if(sum + x <= x +y && set.add(sum + x)){
                queue.add(sum + x);
            }
            if(sum + y <= x + y && set.add(sum + y)){
                queue.add(sum + y);
            }
            if(sum - x >= 0 && set.add(sum - x)){
                queue.add(sum - x);
            }
            if(sum - y >= 0 && set.add(sum - y)){
                queue.add(sum - y);
            }
            if(set.contains(z)){
                return true;
            }
        }
        return false;
    }

    /**
     * DFS 实现算法
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWaterDFS(int x, int y, int z) {
        if( x + y < z ) return false;
        Pair<Integer, Integer> init = new Pair<>(0, 0);
        Set<Pair> set = new HashSet<>();
        set.add(init);
        Stack<Pair> stack = new Stack<>();
        stack.push(init);
        while (!stack.isEmpty()){
            Pair pair = stack.pop();

        }
    }

    public static void main(String[] args) {
        Question_365 question = new Question_365();
        System.out.println(question.canMeasureWaterBFS(6, 2, 5));
    }

}
