package com.steve.algorithms.recruit;

/**
 * 面试题 16.03. 交点
 * <p>
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点
 */
public class Question_1603 {


    public static void main(String[] args) {
        Question_1603 question = new Question_1603();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[] start1 = {};
        int[] end1 = {};
        int[] start2 = {};
        int[] end2 = {};
        double[] res = question.intersection(start1, end1, start2, end2);  // -2147483648
        for (double x : res) {
            System.out.println(x);
        }
    }

    /**
     * 根据 Ax + By + C = 0. 这样可以避免斜率为 0 的计算错误。
     *
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        if (start1[0] == end1[0]) {
            // x = 4 这种直线
        }
        if (start2[0] == end2[0]) {
            // x = 3 这种直线

        }
        // 计算两条直线的斜率
        double k1 = (end1[1] - start1[1]) / (end1[0] - start1[0]);
        double k2 = (end2[1] - start2[1]) / (end2[0] - start2[0]);
        // 计算 b
        double b1 = start1[1] - k1 * start1[0];
        double b2 = start2[1] - k2 * start2[0];
        // 计算交点
        double x = 0, y = 0;
        if (Math.abs(k1) == Math.abs(k2)) {
            // 判断是否重叠
            if (b1 == b2) {
                // 重叠
                x = Math.min(start1[0], start2[0]);
            }
        } else {
            x = (b2 - b1) / (k1 - k2);
            y = x * k1 + b1;
        }
        return new double[]{x, y};
    }
}
