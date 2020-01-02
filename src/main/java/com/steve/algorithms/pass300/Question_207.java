package com.steve.algorithms.pass300;

import com.steve.algorithms.base.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 */
public class Question_207 {

    /**
     * 判断有向无环图是否无环. （效率低下）
     * 原本的思路是 确定有向无环图结构（邻接矩阵法），然后找寻入度为0的顶点，然后删除该顶点并且和他的边，重复操作。
     * 直到入度为0的顶点为0（empty） 这是BFS的思路
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegress = new int[numCourses];
        for(int[] cp: prerequisites) indegress[cp[0]] ++;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < numCourses; i++) if (indegress[i] == 0) queue.add(i);
        while (!queue.isEmpty()){
            Integer pre = queue.poll(); // 入度为0的节点
            numCourses -- ;
            for(int[] cp : prerequisites){
                if(cp[1] != pre) continue;
                if(--indegress[cp[0]] == 0) queue.add(cp[0]);
            }
        }
        return numCourses == 0;
    }


    public static void main(String[] args) {
        Question_207 question = new Question_207();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(question.canFinish(1, new int[][]{{1,0},{0,1}}));
    }

}
