package com.steve.algorithmbook.alg4;


/**
 * Created by liu on 10/10/16.
 * AVL 带有平衡的二叉查找树
 */
public class Avl<T extends Comparable<? super T>>{
    //代表节点的内部嵌套类
    private static class AvlNode<T>{
        /*
        * 节点的高度，每次插入后需要判断该节点的高度是否会发生变化，若发生变化，
        * 　　需要根据插入情况进行单旋转或者双旋转来保持AVL 树的平衡
        * */
        private int height;
        private AvlNode<T> left;
        private AvlNode<T> right;
        private T element;
        //constructor method
        public AvlNode(T ele, AvlNode<T> left,AvlNode<T> right){
            this.element = ele;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
        //for the root node insert
        public AvlNode(T ele){
            this(ele,null,null);
        }
    }

    private AvlNode<T> root;

    public Avl(){
        root = null;
    }

    //judge the height of node
    //if the tree is null,it stand for -1
    private int height(AvlNode<T> t){
        return t==null ? -1: t.height;
    }
    //insert
    public void insert(T t){
        root = insert(t,root);
    }
    public AvlNode<T> insert(T t,AvlNode<T> root){
        if(root == null)
            return new AvlNode<T>(t);
        int compareResult = t.compareTo(root.element);
        if(compareResult < 0){
            root.left = insert(t,root.left);
            //递归调用完毕之后反过来检查是否需要旋转.
            if(height(root.left) - height(root.right) == 2) {
                //判断是单旋转还是双旋转
                if (t.compareTo(root.left.element) > 0) {
                    //左－右旋转
                    //双旋转的实现策略(针对的是当前节点)
                    root = doubleWithLfetChild(root);
                } else {
                    //左－左旋转
                    //单旋转的实现策略(针对的是当前节点)
                    root =  rotateWithLeftChild(root);
                }
            }
        }else if(compareResult > 0){
            root.right = insert(t,root.right);
            if(height(root.right) - height(root.left) == 2){
                //右 - 右　插入
                if(t.compareTo(root.right.element) > 0){
                    root =  rotateWithRightChild(root);
                }else{
                    //右－左插入
                    root = doubleWithRightChild(root);
                }
            }
        }else
            ;
        //树的高度+1  树的高度即该节点到树叶的最长路劲,所以取max，+1 是因为insert operation;
        root.height = Math.max(height(root.left),height(root.right)) + 1;
        return root;
    }
    //单旋转(右－右)
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left),height(k2.right)) +1;
        k1.height = Math.max(k2.height,height(k1.right)) + 1;
        return k1;
    }

    //双旋转(右－左)
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithLeftChild(k3);
    }

    //单旋转(左－左)
    // update height ,then return new root
    public AvlNode<T> rotateWithLeftChild(AvlNode<T> k2){
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left),height(k2.right)) + 1 ;
        k1.height = Math.max(height(k1.left),k2.height) + 1 ;
        return k1;
    }
    //双旋转(左－右)
    //case 2. update height,then return new root.
    public AvlNode<T> doubleWithLfetChild(AvlNode<T> k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    //findMin
    public AvlNode<T> findMin(AvlNode<T> t){
        if(t == null){
            throw new NullPointerException();
        }else if(t.left == null){
            return t;
        }else{
            //return　代表程序的退出，也就没必要在思考递归的后续步骤了
            return findMin(t.left);
        }
    }
    //delete 操作
    //和二叉查找树是一样的。
    public AvlNode<T> remove(T t){
        return remove(t,root);
    }
    public AvlNode<T> remove(T t,AvlNode<T> root){
        if(root == null){
            throw new NullPointerException();
        }
        int compareResult = t.compareTo(root.element);
        if(compareResult > 0){
            root.right = remove(t,root.right);
        }else if(compareResult < 0){
            root.left = remove(t,root.left);
        }else if(root.left != null && root.right != null){
            root.element = findMin(root.right).element;
            root.right = remove(t,root.right);
        }else {
            root = (root.left != null) ? root.left : root.right ;
        }
        return root;
    }
    public boolean contains(T t){
        return contains(t,root);
    }
    public boolean contains(T t,AvlNode<T> root){
        if(root == null)
            return false;
        int a = root.element.compareTo(t);
        if(a>0){
            //比根节点小，从左边找
            return contains(t,root.left);
        }else if(a<0){
            return contains(t, root.right);
        }else{
            return true;
        }
    }
    public void printTree(){
        if(root == null){
            System.out.println("AVLTree is null");
        }else{
            printTree(root);
        }
    }
    //中序遍历(左中右)
    public void printTree(AvlNode<T> root){
        if(root != null){
            printTree(root.left);
            System.out.println(root.element);
            printTree(root.right);
        }
    }
}
