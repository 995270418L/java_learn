package com.steve.cow_guest.classes.c7;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集设计实现，在典型的分布式计算中有广泛的引用场景
 * 有两个主要需求，一个是要求判断两个数据是否在同一个集合中(只需判断它们的父节点的父节点是否指向自己，这就是isSameSet方法的来源)，
 * 一个是合并两个集合(union), 只需将两个集合中数据少的放到集合中数据多的那一端。
 */
public class UnionCheck {

    // 这表示的是几何中储存的数据，可以是String，List，Set
    public static class Node{

    }

    public static class UnionSearchSet{
        // 这个是储存某个节点和它的父节点数据的。key：当前节点，value: 当前节点的父节点
        private HashMap<Node,Node>  fatherMap ;
        // 这个是储存头节点所属集合中有多少个数据的map集合。key: 当前节点，value: 当前节点所属集合中节点的个数
        private HashMap<Node,Integer> sizeMap ;

        public UnionSearchSet(List<Node> nodes){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for(Node node: nodes){
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public boolean isSameSet(Node a,Node b){
           return  findFather(a) == findFather(b);
        }

        /**
         * 合并两个集合
         * @param a a元素所属集合
         * @param b b元素所属集合
         */
        public void unoinSet(Node a, Node b){
            if(a == null || b ==null){
                return ;
            }
            Node aFather = fatherMap.get(a);
            Node bFather = fatherMap.get(b);
            if(aFather != bFather){
                int aSize = sizeMap.get(a);
                int bSize = sizeMap.get(b);
                if(aSize <= bSize){
                    fatherMap.put(aFather,bFather);
                    sizeMap.put(bFather,aSize + bSize);
                }else{
                    fatherMap.put(bFather,aFather);
                    sizeMap.put(aFather,aSize + bSize);
                }
            }
        }

        /**
         * 这里找寻当前节点的父节点还做了一些优化，就是将当前节点至父节点这条链上所有的节点都直接指向父节点上。
         * @param node
         * @return
         */
        private Node findFather(Node node) {
            Node father = fatherMap.get(node);
            if(father != node){
                father = findFather(father);
            }
            // 利用递归函数的特性，如果不用递归函数可以看以下实现
            fatherMap.put(node,father);
            return father;
        }


    }
}
