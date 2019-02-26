package com.steve.cow_guest.classes.c5;

/**
 * Node 结构中含有它的父节点、子节点。求先序、中序、后序遍历中某个节点的后继节点
 * 比如说：  1
 *       2      3
 *     4  5   6  7
 * 先序遍历为1 2 4 5 3 6 7，求5节点的后继节点。
 * 思路: 先序遍历顺序是中-左-右，判断一个节点的后续节点有两种情况， 当前节点的左节点存不存在，①存在，返回左节点。②不存在，判断右节点的存在性
 * ①存在，返回右节点。 ②不存在，返回父节点的第一个右节点。
 * 中序遍历为 4 2 5 1 6 3 7， 求 5 节点的后继节点
 * 思路: 中序遍历为左-中-右，
 */
public class PosNode {

    public static class Node{
        int value;
        Node parent;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 先序遍历找后继节点
     * @param node
     */
    public static Node preLaster(Node node){
        if(node == null){
            return null;
        }
        if(node.left != null){
            return node.left;
        }else{
            if(node.right != null){
                return node.right;
            }else{
                while(node.parent != null && node.parent.right == node){
                    node = node.parent;
                }
                return node.parent == null ? null : node.parent.right;
            }
        }
    }

    /**
     * 中序遍历后继节点
     * @param node
     * @return
     */
    public static Node mOrderLaster(Node node){
        if(node != null){
            // 返回右子树的最右节点
            if(node.right != null){
                node = node.right;
                while (node.left != null){
                    node = node.left;
                }
                return node;
            // 返回节点的父节点的右节点和自己不相等的节点，如果父节点为null，返回null
            }else{
                while(node.parent != null && node.parent.right == node){
                    node = node.parent;
                }
                return node.parent == null ? null : node.parent;
            }
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        Node h = new Node(1);
        h.left = new Node(2);
        h.right = new Node(3);
        h.left.parent = h;
        h.right.parent = h;
        h.left.left = new Node(4);
        h.left.right = new Node(5);
        h.left.left.parent = h.left;
        h.left.right.parent = h.left;

        h.right.left = new Node(6);
        h.right.right = new Node(7);
        h.right.left.parent = h.right;
        h.right.right.parent = h.right;

        Node test = h.left;
        System.out.println(mOrderLaster(test) == null ? "" : mOrderLaster(test).value);
    }
}
