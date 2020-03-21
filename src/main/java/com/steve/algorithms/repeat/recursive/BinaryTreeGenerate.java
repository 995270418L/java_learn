package com.steve.algorithms.repeat.recursive;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 */
public class BinaryTreeGenerate {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        return generate_trees(1, n);
    }

    public List<TreeNode> generate_trees(int start, int end){
        List<TreeNode> allTrees = new ArrayList<>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> leftTrees = generate_trees(start, i-1);
            List<TreeNode> rightTrees = generate_trees(i+1, end);

            for(TreeNode r : rightTrees){
                for(TreeNode l : leftTrees){
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = l;
                    tmp.right = r;
                    allTrees.add(tmp);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode h1 = new TreeNode(9);
        TreeNode h2 = new TreeNode(20);
        TreeNode h3 = new TreeNode(15);
        TreeNode h4 = new TreeNode(7);
        head.left = h1;
        head.right = h2;
        h2.left = h3;
        h2.right = h4;
        BinaryTreeGenerate binaryTreeDepth =new BinaryTreeGenerate();
        System.out.println(binaryTreeDepth.generateTrees(3));
    }

}
