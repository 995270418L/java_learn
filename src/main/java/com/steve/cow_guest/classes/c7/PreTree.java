package com.steve.cow_guest.classes.c7;

/**
 * 前缀树结构实现。
 *
 * 要求: 输入一大堆字符串，"abc","def","efs","bc"。求某个字符串是否出现在这个结构里面。这个时候使用前缀树这种数据结构就能很省时间和空间了。
 *
 *
 * 前缀树的要点是每个头节点保存的是一个数组，从上到下，都是这样。
 *   head
 *   /  \
 *  /\  /\
 */
public class PreTree {

    public static class Node{
        private int path;
        private int end;
        private Node[] next;
        public Node(){
            // 这里只是保存字符串，所以只需有26个大小的数组即可。
            next = new Node[26];
        }
    }

    public static class PreOrderTree{
        private Node root;
        public PreOrderTree(){
            root = new Node();
        }
        // 往前缀树中添加数据
        public void insert(String str){
            if(str == null){
                return ;
            }
            char[] strings = str.toCharArray();
            // 不能改变根节点的引用
            Node node = root;
            int index = 0;
            for(int i=0; i<strings.length; i++){
                index = strings[i] - 'a';
                if(node.next[index] == null){
                    node.next[index] = new Node();
                }
                node = node.next[index];
                node.path ++ ;
            }
            node.end ++;
        }

        /**
         * 判断某一字符串是否存在于前缀树结构中
         * @param str
         * @return
         */
        public boolean search(String str){
            if(str == null){
                return false;
            }
            char[] cas = str.toCharArray();
            Node node = root;
            int index = 0;
            for(int i=0; i<cas.length; i++){
                index = cas[i] - 'a';
                if(node.next[index] == null){
                    return false;
                }
                node = node.next[index];
            }
            return true;
        }

        /**
         * 删除某个字符串
         * @param str
         */
        public void delete(String str){
            if(str == null){
                return ;
            }
            if(!search(str)){
                return;
            }
            char[] cas = str.toCharArray();
            int index = 0;
            Node node = root;
            for(int i = 0; i< cas.length; i++){
                index = cas[i] - 'a';
                if(-- node.next[index].path == 0){
                    node.next[index] = null;
                    return ;
                }
                node = node.next[index];
            }
            node.end --;
        }
    }
}
