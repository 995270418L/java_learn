package com.steve.algorithms.recruit;

import com.steve.algorithms.base.Pair;

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

    boolean flag = false; // 表明是否找到结果
    int capacityX, capacityY;
    int[][] visited;
    /**
     * 状态定义， dp(x, y, z) 表示 x， y 容量时 z 的结果
     * 状态转移:
     *
     *  1. 将 X 装满   dp(capacityX, y, z)
     *  2. 将 Y 装满   dp(x, capacityY, z)
     *  3. 将 X 倒空   dp(0, y, z)
     *  4. 将 Y 倒空   dp(x, 0, z)
     *  5. 将 Y 倒入 X dp(Math.min(capacityX, x + y), Math.max(0, y - (capacityX-x)), z)
     *  6. 将 X 倒入 Y dp(Math.max(0, x - (capacityY - y)), math.min(capacityY, x + y), z)
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWaterDP(int x, int y, int z){
        capacityX = x;
        capacityY = y;
        visited = new int[x + 1][y + 1];
        dp(0,0, z);
        return flag;
    }

    public void dp(int x, int y, int z){
        if(flag) return ;
        if(x == z || y == z || x + y == z){
            flag = true;
            return;
        }
        if(visited[x][y] == 1){
            return;
        } else {
            visited[x][y] = 1;
        }
        dp(0, y, z);
        dp(x, 0, z);
        dp(x, capacityY, z);
        dp(capacityX, y, z);
        // x 倒入 y
        dp(Math.max(0, x - (capacityY - y)), Math.min(capacityY, x + y), z);
        dp(Math.min(x + y, capacityX), Math.max(0, y - (capacityX - x)), z);
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
        Stack<Pair> stack = new Stack<>();
        stack.push(init);
        while (!stack.isEmpty()){
            Pair<Integer, Integer> pair = stack.pop();
            int k = pair.getKey();
            int v = pair.getValue();
            if(k == z || v == z || k + v == z){
                return true;
            }
            if(!set.add(pair)) continue;
            stack.add(new Pair(0, v));
            stack.add(new Pair(k, 0));

            stack.add(new Pair(x, v));
            stack.add(new Pair(k, y));

            // x 倒入 y
            stack.add(new Pair(Math.max(0, k -(y -v)), Math.min(y, k + v)));
            // y 倒入 x
            stack.add(new Pair(Math.min(x, k + v), Math.max(0, v - (x - k))));
        }
        return false;
    }

    public static void main(String[] args) {
        Question_365 question = new Question_365();
        System.out.println(question.canMeasureWaterDFS(3, 5, 4));
    }

}
