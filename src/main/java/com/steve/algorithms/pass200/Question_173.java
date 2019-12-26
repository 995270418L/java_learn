package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.Queue;
import java.util.Stack;

/**
 *
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 示例：
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 */
public class Question_173 {

    private Queue<Integer> res;

    private void middle(TreeNode root){
        if(root != null){
            middle(root.left);
            res.add(root.val);
            middle(root.right);
        }
    }


    /**
     * 简单粗暴的方法，先中序遍历，结果会是一个升序数组
     * @param root
     */
//    public Question_173(TreeNode root) {
//        this.res = new LinkedList<>();
//        middle(root);
//    }

    private Stack<TreeNode> stack ;
    private TreeNode curr;
    public Question_173(TreeNode root) {
        this.stack = new Stack<>();
        this.curr = root;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = null;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            res = stack.pop();
            curr = res.right;
            break;
        }
        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(15);
        TreeNode root3 = new TreeNode(9);
        TreeNode root4 = new TreeNode(20);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;

        Question_173 question = new Question_173(root);
        System.out.println(question.next());
        System.out.println(question.next());
        System.out.println(question.next());
        System.out.println(question.next());
        System.out.println(question.next());
    }

}
