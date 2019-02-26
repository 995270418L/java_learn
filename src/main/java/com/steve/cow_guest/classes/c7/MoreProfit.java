package com.steve.cow_guest.classes.c7;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 两个数组，一个数组表示项目花费，一个表示项目利润。求在出事本金为w，只能做有限次项目k次的情况下
 * 利润+本金最大化的方案
 */
public class MoreProfit {

    public static class Node{
        int c;
        int p;
        public Node(int c, int p){
            this.c = c;
            this.p = p;
        }
    }

    public static class ProfitComparator implements Comparator<Node> {

        /**
         * 大于1 就表示升序排序(默认)
         * 小于1 降序排序。
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Node o1, Node o2) {
            return -(o1.p - o2.p);
        }
    }

    public static class CostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static int moreProfit(int w, int k, int[] cost, int[] profit){
        Node[] nodes = new Node[profit.length];
        for(int i=0; i<profit.length ;i++){
            nodes[i] = new Node(cost[i],profit[i]);
        }
        PriorityQueue<Node> minCostNodes = new PriorityQueue<>(new CostComparator());
        PriorityQueue<Node> maxProfitNodes = new PriorityQueue<>(new ProfitComparator());
        for(Node node: nodes){
            minCostNodes.add(node);
        }
        for(int i=0; i<k; i++){
            while (!minCostNodes.isEmpty() && minCostNodes.peek().c <= w){
                Node cur = minCostNodes.poll();
                maxProfitNodes.add(cur);
            }
            if(maxProfitNodes.isEmpty()){
                return w;
            }
            w += maxProfitNodes.poll().p;
        }
        return w;
    }

    public static void main(String[] args) {
        int result = moreProfit(10,3,new int[]{5,10,12,15},new int[]{3,6,1,1});
        System.out.println(result);
    }
}
