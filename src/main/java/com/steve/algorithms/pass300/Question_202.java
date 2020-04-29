package com.steve.algorithms.pass300;

import com.steve.algorithms.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单：
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */
public class Question_202 {

    /**
     * 快慢指针 思想，总会相遇，如果相遇时结果为1，则是快乐数，反之则不是。
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = squareNum(slow);
            fast = squareNum(fast);
            fast = squareNum(fast);
        }while (slow != fast);

        return slow == 1;
    }


    public int squareNum(int n){
        int sum  = 0;
        while (n > 0){
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    /**
     * 集合的方法
     * @param n
     * @return
     */
    public boolean isHappy2 (int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        while(!map.containsKey(n)){
            map.put(n, n);
            n = squareNum(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Question_202 question = new Question_202();
        TreeNode root = new TreeNode(1);
        System.out.println(question.isHappy2(9));
    }

}
