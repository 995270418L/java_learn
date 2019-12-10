package com.steve.algorithms.pass200;

import com.steve.algorithms.base.Node;

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
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
        System.out.println(question.getRow(3));
    }

}
