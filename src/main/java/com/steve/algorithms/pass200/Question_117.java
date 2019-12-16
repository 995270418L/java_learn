package com.steve.algorithms.pass200;

import com.steve.algorithms.base.Node3;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给定一个二叉树
 *
 * struct Node3 {
 *   int val;
 *   Node3 *left;
 *   Node3 *right;
 *   Node3 *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 * 示例：
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 * 提示：
 *
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 *
 *
 */
public class Question_117 {

    /**
     * 只能用递归了
     * @param root
     * @return
     */
    public Node3 connect(Node3 root) {
        if(root == null) return root;
        Queue<Node3> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node3 cur = null;
            int size = queue.size();
            for(int i=0; i < size; i++){
                Node3 tmp = queue.poll();
                if(cur != null){
                    cur.next = tmp;
                }
                cur = tmp;
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Question_117 question = new Question_117();
        Node3 node31 = new Node3(1);
        Node3 node32 = new Node3(2);
        Node3 node3 = new Node3(3);
        Node3 node34 = new Node3(4);
        Node3 node35 = new Node3(5);
        Node3 node36 = new Node3(6);

        node31.left = node32;
        node31.right = node3;

        node32.left = node34;
        node32.right = node35;

        node3.right = node36;
        System.out.println(question.connect(node31));
    }

}
