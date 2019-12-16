package com.steve.algorithms.pass200;

import com.steve.algorithms.base.Node3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 简单:
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
        System.out.println(question.generate(5));
    }

}
