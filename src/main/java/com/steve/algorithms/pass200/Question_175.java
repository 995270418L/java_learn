package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.Queue;
import java.util.Stack;

/**
 * 简单：
 *SQL架构
 * 表1: Person
 *
 * +-------------+---------+
 * | 列名         | 类型     |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * PersonId 是上表主键
 * 表2: Address
 *
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * AddressId 是上表主键
 *
 *
 * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
 *
 *
 *
 * FirstName, LastName, City, State
 *
 *
 */
public class Question_175 {

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
    public Question_175(TreeNode root) {
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

        Question_175 question = new Question_175(root);
        System.out.println(question.next());
        System.out.println(question.next());
        System.out.println(question.next());
        System.out.println(question.next());
        System.out.println(question.next());
    }

}
