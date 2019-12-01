package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Question_105 {

    private int rootIdx = 0;
    private Map<Integer, Integer> map = new HashMap();
    private int[] preorder = null;
    private int[] inorder = null;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recursive(0, inorder.length);
    }

    public TreeNode recursive(int left, int right){
        if(left == right) return null;
        int rootVal = preorder[rootIdx++];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(root.val);
        root.left = recursive(left, index);
        root.right = recursive(index+1, right);
        return root;
    }

    public static void main(String[] args) {
        Question_105 question = new Question_105();
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
        int[] preorder = {3, 9, 20, 15 ,7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(question.buildTree(preorder, inorder));
    }

}
