package com.steve.algorithms;


/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 */
public class Question_11 {

    /**
     * 暴力枚举法
     * @param height
     * @return
     */
    public int maxAreaViolence(int[] height) {
        int maxSize = 0, start =0, end =0;
        for(int i=0; i< height.length; i++){
            for(int j=i+1; j< height.length ;j++){
                int size = Math.min(height[j], height[i]) * (j-i);
                if(size > maxSize){
                    start = i;
                    end = j;
                    maxSize = size;
                }
            }
        }
        System.out.println(start + "\t" + end);
        return maxSize;
    }

    /**
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
         int start = 0, end = height.length - 1;
         int maxSize = 0;
         while(start < end){
             int tmpSize = 0;
             if(height[start] < height[end]){
                 tmpSize = height[start] * (end - start);
                 start ++;
             }else{
                 tmpSize = height[end] * (end - start);
                 end --;
             }
             maxSize = Math.max(maxSize, tmpSize);
         }
        return maxSize;
    }

    public static void main(String[] args) {
        Question_11 q = new Question_11();
        int [] p = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(q.maxArea(p));
    }

}
