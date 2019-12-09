package com.steve.algorithms.pass200;

import com.steve.algorithms.base.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 *
 */
public class Question_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i <= numRows; i++){
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            int row = i -1 ;
            while (list.size() < i ){
                if(list.size() == i - 1){
                    list.add(1); // 末尾元素
                    break;
                }
                List<Integer> last = res.get(row-1);
                list.add(last.get(list.size() - 1) + last.get(list.size()));
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Question_118 question = new Question_118();
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
        System.out.println(question.generate(5));
    }

}
