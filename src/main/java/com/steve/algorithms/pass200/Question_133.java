package com.steve.algorithms.pass200;

import com.steve.algorithms.base.Node2;

import java.util.*;

/**
 *
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node3]）。
 *
 * 示例：
 *
 *
 *
 * 输入：
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},
 * {"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *  
 *
 * 提示：
 *
 * 节点数介于 1 到 100 之间。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 必须将给定节点的拷贝作为对克隆图的引用返回。
 *
 */
public class Question_133 {

    /**
     * bfs , 使用hashMap 记录访问过的节点
     * @param node2
     * @return
     */
    public Node2 cloneGraph(Node2 node2) {
        if(node2 == null) return null;
        Node2 head = new Node2();
        Map<Integer, Node2> map = new HashMap<>();
        Queue<Node2> queue = new LinkedList<>();
        queue.add(node2);
        while (!queue.isEmpty()){
            Node2 temp = queue.poll();
            Node2 nd = null; // 新node
            if(map.containsKey(temp.val)){
                nd = map.get(temp.val);
            }else{
                nd = new Node2(temp.val, new ArrayList<>());
                map.put(temp.val, nd);
            }
            if(map.size() == 1) head = nd;
            List<Node2> lists = temp.neighbors;
            for(Node2 tNode2 : lists){
                if(map.containsKey(tNode2.val)){
                    nd.neighbors.add(map.get(tNode2.val));
                }else{
                    queue.add(tNode2);
                    Node2 t = new Node2(tNode2.val, new ArrayList<>());
                    nd.neighbors.add(t);
                    map.put(tNode2.val, t);
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Question_133 question = new Question_133();
        char[][] src = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        System.out.println(question.cloneGraph(null));
    }

}
