package com.steve.algorithms.pass300;


import com.steve.algorithms.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2^h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class Question_222 {

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count += size;
            for(int i=0; i< size; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
        return count;
    }

    /**
     * 递归解法 (击败 100%)
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if(root == null) return 0;
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }


    /**
     * 运用特点解决
     * @param root
     * @return
     */
    public int countNodes3(TreeNode root) {
        if(root == null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            // 左子树一定是满的，左子树的节点总数为 2 ^ left - 1, 加上 root 节点， 就是 2 ^ left 的值了
            return countNodes3(root.right) + (1 << left);
        }else{
            // 倒数第二层一定是满的，右子树节点总数 2 ^ right - 1, 加上root节点，就是 2 ^ right 的值了
            return countNodes3(root.left) + (1 << right);
        }
    }

    public int countLevel(TreeNode node){
        int level = 0;
        while(node != null){
            level ++;
            node = node.left;
        }
        return level;
    }



    public static void main(String[] args) {
        Question_222 question = new Question_222();
        TreeNode t1 = new TreeNode(1);
        System.out.println(question.countNodes(t1));
    }

}
