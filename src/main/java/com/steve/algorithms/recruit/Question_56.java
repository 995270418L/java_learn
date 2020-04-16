package com.steve.algorithms.recruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题13. 机器人的运动范围
 */
public class Question_56 {

    public static void main(String[] args) {
        Question_56 question = new Question_56();
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] target = question.merge(arr);  // 16, 8, 4
        System.out.println(target);
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();
        if (intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        list.add(intervals[0]);
        int i = 1;
        while (i < intervals.length) {
            int[] secI = intervals[i];
            int[] peek = list.get(list.size() - 1);
            if ((peek[1] >= secI[0] && peek[1] <= secI[1])) {
                list.remove(list.size() - 1);
                list.add(new int[]{peek[0], secI[1]});
            } else if (peek[1] >= secI[1]) {

            } else {
                list.add(secI);

            }
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

}
