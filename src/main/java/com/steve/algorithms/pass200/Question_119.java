package com.steve.algorithms.pass200;

import com.steve.algorithms.base.Node3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 简单:
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 *
 */
public class Question_119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0) return res;
        if(rowIndex == 0) {
            res.add(1);
            return res;
        }
        if(rowIndex == 1) {
            res.add(1);
            res.add(1);
            return res;
        }
        res.add(1);
        res.add(1);
        for(int i=2; i<= rowIndex; i++){
            List<Integer> temp = new ArrayList<>(i);
            temp.add(1);
            for(int j=1; j < i ; j++){
                temp.add(res.get(j-1) + res.get(j));
            }
            temp.add(1);
            res = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        Question_119 question = new Question_119();
        Node3 node31 = new Node3(1);
        Node3 node32 = new Node3(2);
        Node3 node3 = new Node3(3);
        Node3 node34 = new Node3(4);
        Node3 node35 = new Node3(5);
        Node3 node36 = new Node3(6);

        node31.left = node32;
        node31.right = node3;

        node32.left = node34;
        node32.right = node35;

        node3.right = node36;
        System.out.println(question.getRow(3));
    }

}
