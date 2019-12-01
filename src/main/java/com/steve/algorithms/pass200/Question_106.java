package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Question_106 {

    private int[] postorder;
    private int rootIdx;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        this.postorder = postorder;
        this.rootIdx = postorder.length - 1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recursive(0, inorder.length);
    }

    public TreeNode recursive(int left, int right){
        if(left == right) return null;
        int rootVal = postorder[rootIdx--];
        int index = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = recursive(index + 1, right);
        root.left = recursive(left, index);
        return root;
    }

    public static void main(String[] args) {
        Question_106 question = new Question_106();
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
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(question.buildTree(inorder, postorder));
    }

}
