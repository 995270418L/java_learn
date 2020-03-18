package com.steve.algorithms.recruit;

/**
 * 836. 矩形重叠
 *
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 */
public class Question_836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec2[0] >= rec1[2]){ // x1 >= x2'
            return false;
        }else if(rec2[2] <= rec1[0]){
            return false;
        }else if(rec2[1] >= rec1[3]){
            return false;
        }else if(rec2[3] <= rec1[1]){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        Question_836 question = new Question_836();
        int[][] src = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        System.out.println(question.isRectangleOverlap(rec2, rec1));
    }

}
