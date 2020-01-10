package com.steve.algorithms.pass300;


import com.steve.algorithms.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 *
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 *
 *
 *
 * 示例:
 *
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围
 *
 */
public class Question_223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        int s = 0;
        if(E >= C || G <= A || H <= B || F >= D) s = 0;
        else{
            int x1 = Math.max(E, A);
            int y1 = Math.max(B, F);

            int x2 = Math.min(C, G);
            int y2 = Math.min(D, H);
            s = (x2 - x1) * (y2 - y1);
        }
        return area1 + area2 - s;
    }

    public static void main(String[] args) {
        Question_223 question = new Question_223();
        TreeNode t1 = new TreeNode(1);
        System.out.println(question.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

}
