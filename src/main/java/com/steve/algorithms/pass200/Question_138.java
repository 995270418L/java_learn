package com.steve.algorithms.pass200;

import com.steve.algorithms.base.Node;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。 
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *  
 *
 * 提示：
 *
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 *
 */
public class Question_138 {


    private Map<Node, Node> visitedMap = new HashMap<>();

    /**
     * 递归
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(visitedMap.containsKey(head)) return visitedMap.get(head);
        Node node = new Node(head.val, null, null);
        visitedMap.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public Node copyRandomListIter(Node head){
        if(head == null) return null;
        Node oldNode = head;
        Node newNode = new Node(oldNode.val, null, null);
        visitedMap.put(oldNode, newNode);
        while (oldNode != null){
            newNode.next = getCloneNode(oldNode.next);
            newNode.random = getCloneNode(oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visitedMap.get(head);
    }

    private Node getCloneNode(Node node){
        if(node != null){
            if(visitedMap.containsKey(node)){
                return visitedMap.get(node);
            }else{
                Node newNode = new Node(node.val, null, null);
                visitedMap.put(node, newNode);
                return newNode;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Question_138 question = new Question_138();
        char[][] src = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        System.out.println(question.copyRandomList(null));
    }

}
