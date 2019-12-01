package com.steve.algorithms.pass100;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class Question_95 {

    /**
     * 动态规划
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        List<TreeNode>[] dp = new LinkedList[n+1];
        dp[0] = new LinkedList();
        dp[0].add(null);
        for(int len =1; len <=n ;len ++){
            dp[len] = new LinkedList();
            // 将不同的数字作为根节点，只需要考虑到len
            for (int root=1; root<=len; root++){
                // 左子树 长度
                int leftTree = root-1;
                int rightTree = len - root;
                // 左右子树两两组合
                for(TreeNode left: dp[leftTree]){
                    for(TreeNode right: dp[rightTree]){
                        TreeNode treeNode = new TreeNode(root);
                        treeNode.left = left;
                        treeNode.right = clone(right, root);
                        dp[len].add(treeNode);
                    }
                }
            }
        }
        return dp[n];
    }

    public TreeNode clone(TreeNode rightNode, int offset){
        if(rightNode == null){
            return null;
        }
        TreeNode node = new TreeNode(rightNode.val + offset);
        node.left = clone(rightNode.left, offset);
        node.right = clone(rightNode.right, offset);
        return node;
    }


    /**
     * 递归解法，对每个节点都进行根节点假设，假设每个节点都是根节点，然后递归构建左右子树，最后拼接在一起
     */
    public List<TreeNode> add(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i=start; i <= end; i++){
            List<TreeNode> leftTree = add(start, i - 1);
            List<TreeNode> rightTree = add(i+1, end);

            // 左右子树两两组合
            for(int j=0; j< rightTree.size(); j++){
                for(int k=0; k< leftTree.size(); k++){
                    TreeNode treeNode  = new TreeNode(i);
                    treeNode.left = leftTree.get(k);
                    treeNode.right = rightTree.get(j);
                    res.add(treeNode);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Question_95 question = new Question_95();
        TreeNode tmp = new TreeNode(1);
        TreeNode tmp2 = new TreeNode(2);
        TreeNode tmp3 = new TreeNode(3);
        TreeNode tmp4 = new TreeNode(4);
        TreeNode tmp5 = new TreeNode(5);
        TreeNode tmp6 = new TreeNode(6);
        tmp.left = tmp2;
        tmp.right = tmp3;
        tmp2.left = tmp4;
        tmp2.right = tmp5;
        tmp3.left = tmp6;
        System.out.println(question.generateTrees(3));
    }

}
