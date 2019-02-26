package com.steve.cow_guest.classes.c5;

import com.steve.cow_guest.classes.c5.BtSerialize.Node;

/**
 * 完全二叉树求其节点个数: 先填满左子树，再填满右子树的树为完全二叉树。要求时间复杂度小于 0(N)
 * 运用满二叉树节点公式(节点总数 = 2^n - 1 n为二叉树节点高度)和递归思路去解。
 */
public class CBTNodeNumber {

    public static void main(String... args){
        Node h1 = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        Node h4 = new Node(4);
        Node h5 = new Node(5);
        Node h6 = new Node(6);
        Node h7 = new Node(7);
        h1.left = h2;
        h1.right = h3;
        h2.left = h4;
//        h2.right = h5;
//        h3.left = h6;
//        h3.right = h7;
//        System.out.println(h(h1,1));

        long n = 10000000000L;
        double p = 0.0001;
        long m = (long) (-(n*Math.log(p))/(Math.pow(Math.log(2),2)));  //得出来单位是byte
        System.out.println(m);
        int result = (int) (m/8/1024/1024/1024);  // 转换成GB
        System.out.println("所需内存空间大小(GB): " + result);
        int k = (int) (m/n*Math.log(2));
        System.out.println("需要的hash函数个数k: " + k);
        double pR = Math.pow(1-Math.pow(2.718,-k*n/m),k);
        String s = String.format("%.10f",pR);
        System.out.println("实际误差率: " + s);
    }

    /**
     * 个人根据思路写的，步骤:
     * 1. 求当前节点的高度h
     * 2. 判断当前节点右子树的最左节点的高度和 h 是否相等
     * 3. 若第二步结果相等，则最终结果为左子树的节点数(2^(h-1) 这里面包含了当前节点) + 递归求当前节点的左子树根节点
     *    若第二步结果不等，则最终结果为右子树总节点数(包括当前节点 2^(h-1-1) ) + 递归求当前节点的左子树根节点数据
     * @param node
     * @param level
     * @return
     */
    public static int h(Node node,int level){
        if(node == null){
            return 0;
        }
        // 完全二叉树，左节点一定是满的。
        int height = getNodeHeight(node);
        // 表示当前节点的右子树的最左节点是不是刚好和层高相同
        boolean valid = judgeRight(node.right,height,1);
        if(valid){
            return (1 << (height - 1)) + h(node.right,level + 1);
        }else{
            return (1 << (height - 2)) + h(node.left,level + 1);
        }
    }


    public static int nodeNum(Node head){
        if (head == null) {
            return 0;
        }
        return bs(head,mostLeftLevel(head, 1), 1);
    }

    /**
     * 学习左神的写法
     * @param node 当前节点
     * @param height 节点高度
     * @param level 节点所属层次
     * @return
     */
    public static int bs(Node node, int height,int level){
        if(height == level){
            return 1;
        }
        if(mostLeftLevel(node.right,level + 1) == height){
            return (1 << (height - 1 )) + bs(node.right, height,level + 1);
        }else{
            return (1 <<(height - 2 )) + bs(node.left,height,level + 1);
        }
    }

    private static int mostLeftLevel(Node node, int level) {
        if(node != null){
            level ++;
            node = node.left;
        }
        return level - 1;
    }

    private static boolean judgeRight(Node node, int height,int level) {
        while(node != null){
            level ++;
            node = node.left;
        }
        return level == height ? true: false;
    }

    /**
     * 求当前节点的高度
     * @param node 当前节点
     * @return
     */
    private static int getNodeHeight(Node node) {
        int res = 0;
        while(node!= null){
            res ++ ;
            node = node.left;
        }
        return res;
    }
}
