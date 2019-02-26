package com.steve.cow_guest.typical.binaryTree;

import com.steve.cow_guest.common.Node;

import java.util.Stack;

/**
 * @Author: steve
 * @Date: Created in 10:15 2018/3/1
 * @Description: 非递归的遍历树
 * @Modified By:
 */
public class NoRecursiveTraverse {

    public static void main(String[] args) {
        Node root = generatorTree();
        secondTraverse(root);
    }

    /**
     * 先序遍历实现
     *  借用一个栈，先放root节点，再放右节点，再放左节点
     * @param root
     */
    private static void firstTraverse(Node root) {
        Stack<Node<Integer>> stack = new Stack();
        stack.push(root);
        while(stack.size() > 0){
            Node<Integer> tmp = stack.pop();
            System.out.print(tmp.getValue() + " ");
            if(tmp.getRight() != null){
                stack.push(tmp.getRight());
            }
            if(tmp.getLeft() != null){
                stack.push(tmp.getLeft());
            }
        }
    }

    /**
     * 中序遍历
     *   准备一个变量cur和一个栈，跟踪最左节点，并压入栈，当找到最左节点时，弹出，并找寻当前节点的右节点，当右节点不为空时，
     * 令cur等于当前弹出节点的右节点
     * @param root
     */
    private static void secondTraverse(Node<Integer> root){
        if(root == null){
            return;
        }
        Stack<Node<Integer>> stack = new Stack<>();
        Node cur = root;
        while(cur != null || stack.size() > 0){
            while(cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }
            if(stack.size() > 0){
                cur = stack.pop();
                System.out.print(cur.getValue()+" ");
                cur = cur.getRight();
            }
        }
    }

    /**
     * 后序遍历
     *   准备两个栈，一个栈按照中--->左---->右节点的方式压入数据，当压入第一个节点时，弹出当前节点并压入第二个栈，
     *   同时判断当前节点是否有左右节点，有就先压入左节点，再压入右节点。压完就弹出当前栈的最顶层节点至第二个栈，
     * @param root
     */
    private static void thirdTraverse(Node<Integer> root){
        if(root == null){
            return;
        }
        // 压入栈
        Stack<Node<Integer>> stackIn = new Stack<>();
        // 弹出栈
        Stack<Node<Integer>> stackOut = new Stack<>();
        stackIn.push(root);
        while (stackIn.size() > 0){
            Node node = stackIn.pop();
            stackOut.push(node);
            if(node.getLeft() != null){
                     stackIn.push(node.getLeft());
            }
            if(node.getRight() != null){
                stackIn.push(node.getRight());
            }
        }
        while (stackOut.size() > 0){
            System.out.print(stackOut.pop().getValue() + " ");
        }
    }

    private static Node generatorTree() {
        Node<Integer> root = new Node(1);
        Node<Integer> root1 = new Node(2);
        Node<Integer> root2 = new Node(3);
        Node<Integer> root3 = new Node(4);
        Node<Integer> root4 = new Node(5);
        Node<Integer> root5 = new Node(6);
        Node<Integer> root6 = new Node(7);
        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root3);
        root1.setRight(root4);
        root2.setLeft(root5);
        root2.setRight(root6);
        return root;
    }
    
}
