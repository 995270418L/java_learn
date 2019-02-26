package com.steve.interviews;

import java.util.*;

/**
 * Created by liu on 3/16/17.
 */
public class Main {

//    public static void main(String... args){
//        sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int num = sc.nextInt();
//            int count = 0;
//            //判断它的长度
//            for(int i=1;i<= num;i++){
//                char[] tmp = String.valueOf(i).toCharArray();
//                int tmp_len = tmp.length;
//                int judge = 0;
//                for(int j=0;j<tmp_len;j++){
//                    if(tmp[j] == '1' || tmp[j] == '0') {
//                       judge ++ ;
//                    }
//                }
//                if(judge == tmp_len){
//                    count ++ ;
//                }
//            }
//            System.out.println(count);
//        }
//    }

    //2进制的处理方案
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            String str = scanner.next();
//            int length = str.length();
//            int result = 0;
//            for(int i=0;i<length;i++){
//                if(str.charAt(i)>'1'){
//                    result += Math.pow(2,length-i)-1;
//                    break;
//                }else if(str.charAt(i)=='1'){
//                    result += Math.pow(2,length-1-i);
//                }
//            }
//            System.out.println(result);
//        }
//    }

//    //8进制的处理方案
//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String str = sc.next();
//            int length = str.length();
//            int result = 0;
//            for(int i=0;i<length;i++){
//                if(str.charAt(i) <= '7'){
//                    result += Math.pow(7,length-i-1) * Integer.valueOf(String.valueOf(str.charAt(i)));
//                }else{
//                    result += Math.pow(7,length-i);
//                }
//            }
//            System.out.println(result);
//        }
//    }

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            Vector<Character> vector = new Vector();
//            for(int i=0;i<3;i++) {
//                String line = sc.next();
//                vector.addElement(line.charAt(0));
//                vector.addElement(line.charAt(1));
//                vector.addElement(line.charAt(2));
//            }
//            //寻找对称位置的数据
//            boolean same = true;
//            for(int i=0;i<3;i++){
//                if(vector.get(i) != vector.get(8-i)){
//                    same = false;
//                }
//            }
//            if(same){
//                System.out.println("YES");
//            }else{
//                System.out.println("NO");
//            }
//        }
//    }

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String input = sc.next();
//            String s1 = sc.next();
//            String s2 = sc.next();
//            boolean fwd = false;
//            boolean back = false;
//            //正反位置看看是否包含
//            int idx = input.indexOf(s1);   //aaacaaa aca aa  ab a a
//            if(idx != -1){
//                idx += s1.length();
//                if(input.substring(idx).contains(s2)){
//                    fwd = true;
//                }
//            }
//            String input_rev = new StringBuilder(input).reverse().toString();
//            idx = input_rev.indexOf(s1);
//            if(idx != -1){
//                idx += s1.length();
//                if(input_rev.substring(idx).contains(s2)){
//                    back = true;
//                }
//            }
//            if(fwd){
//                if(back){
//                    System.out.println("both");
//                }else{
//                    System.out.println("forward");
//                }
//            }else{
//                if(back){
//                    System.out.println("backward");
//                }else{
//                    System.out.println("invalid");
//                }
//            }
//        }
//        sc.close();
//    }

//    public static void main(String... args){
//        int[][] array = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
//        boolean a = find(11,array);
//        System.out.println(a);
//    }
//
//    static boolean find(int target,int[][] array){
//        if(array.length < 1 || array[0].length <1 || array == null){
//            return false;
//        }
//        int rows = array.length;
//        int cols = array[0].length;
//
//        //开始行号
//        int row = 0;
//        int col = cols-1;
//        while(row < rows && row >=0 && col>=0 && col < cols){
//            if (array[row][col] == target){
//                return true;
//            }else if(array[row][col] < target){
//                row++;
//            }else{
//                col --;
//            }
//        }
//        return false;
//    }

//    public static void main(String... args){
//        StringBuffer sb1 = new StringBuffer("We are Happy");
////        StringBuffer sb2 = new StringBuffer();
////        String[] a = sb1.toString().split(" ");
////        for(int i=0 ;i<a.length;i++){
////            sb2.append(a[i]).append("%20");
////        }
////        System.out.println(sb2.substring(0,sb2.length()-3).toString());
//       String a =  sb1.toString();
//       System.out.println(a);
//       System.out.println(a.replace(" ","20%"));
//    }

//    public static void main(String... args){
//        StringBuffer a = new StringBuffer("A");
//        StringBuffer b = new StringBuffer("B");
//        operator(a,b);
//        System.out.println(a + ","+ b);
//    }
//    static void operator(StringBuffer x,StringBuffer y){
//        x.append(y);
//        y = x;        //这句话应该是无效的?
//    }

//    public static void main(String... args){
//        Map map = new HashMap();
//        map.put("name",null);   // null 为保留字
//        map.put("name","Jack");
//        System.out.println(map.size());
//    }
//    public static void main(String... args){
//        Object o = new Object(){
//            public boolean equals(Object o){
//                return true;
//            }
//        };
//        System.out.println(o.equals("Fred"));
//    }

//    static class TreeNode{
//        int val = 0;
//        TreeNode left = null;
//        TreeNode right = null;
//        public TreeNode(int val) {
//            this.val = val;
//        }
//    }
//
//    public static void Mirror(TreeNode root) {
//        if(root == null) return;
//        TreeNode tmp = null;
//        tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//        Mirror(root.left);
//        Mirror(root.right);
////        change(root.left,root.right);
//    }
//
//    static void change(TreeNode left,TreeNode right){
//        if(left == null || right == null) return;
//        TreeNode tmp = null;
//        tmp = left;
//        left = right;
//        right = tmp;
//        change(left.left,left.right);
//        change(right.left,right.right);
//    }
//
//    public static void main(String... args){
//        //{8,6,10,5,7,9,11}
//        TreeNode root = new TreeNode(8);
//        TreeNode root2 = new TreeNode(6);
//        TreeNode root3 = new TreeNode(10);
//        TreeNode root4 = new TreeNode(5);
//        TreeNode root5 = new TreeNode(7);
//        TreeNode root6 = new TreeNode(9);
//        TreeNode root7 = new TreeNode(11);
//        root.left = root2;
//        root.right = root3;
//        root2.left = root4;
//        root2.right = root5;
//        root3.left = root6;
//        root3.right = root7;
//        Mirror(root);
//    }
//
//    public static void main(String... args){
//        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
//        ArrayList<Integer> list = printMatrix(matrix);
//        for(Integer i : list){
//            System.out.println(i);
//        }
//    }
//    public static ArrayList<Integer> printMatrix(int [][] matrix) {
//        if(matrix == null) return new ArrayList(0);
//        ArrayList<Integer> list = new ArrayList();
//        int start  = 0;
//        int i = matrix.length;  //行数
//        int j = matrix[0].length;  //列数
//        for(int l=i,m=j,s=0,e=0,loop=0; l>0 && m>0; l -= 2,m -= 2){
//            //s 代表行 e代表列 loop代表外循环的次数
//            // 1
//            //先添加列
//            for(int k=e; k<j-loop; k++){
//                list.add(matrix[s][k]);
//                e++;
//            }
//            //为下一次循环准备变量s,e
//            // 2
//            e--;
//            s++;
//            if(e < 0 || s < 0) break;
//            //再添加行
//            for(int k=s; k<i-loop; k++){
//                list.add(matrix[k][e]);
//                s++;
//            }
//            //为下一次循环准备变量s,e
//            // 3
//            e--;
//            s--;
//            if(e < 0 || s < 0) break;
//            //再添加列
//            //循环到第二次时行不能为0;
//            for(int k=e; k>loop-1 && s != 0; k--){
//                list.add(matrix[s][k]);
//                e--;
//            }
//            //为下一次循环准备变量s,e
//            // 4
//            s-- ;
//            e++ ;
//            if(e < 0 || s < 0) break;
//            //再添加行
//            for(int k=s; k>loop && e >= 0;k--){
//                list.add(matrix[k][e]);
//                s--;
//            }
//            //为下一次循环准备变量s,e
//            e++ ;
//            s++ ;
//            loop ++;
//            if(e < 0 || s < 0) break;
//        }
//        return list;
//    }

//    public static void main(String... args){
//        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(3);
//        stack.push(2);
//        stack.push(1);
////        System.out.println(stack.pop());
//        for(Integer i : stack){
//            System.out.println(i);
//        }
//
//    }

//    public static void main(String... args){
//        Stack stack = new Stack();
//        stack.peek();
//    }

   static class TreeNode{
       int val = 0;
       TreeNode left = null;
       TreeNode right = null;
       TreeNode(int val){
           this.val = val;
       }
   }
   public static void main(String... args){
       TreeNode tr1 = new TreeNode(1);
       TreeNode tr2 = new TreeNode(2);
       TreeNode tr3 = new TreeNode(3);
       TreeNode tr4 = new TreeNode(4);
       TreeNode tr5 = new TreeNode(5);
       TreeNode tr6 = new TreeNode(6);
       TreeNode tr7 = new TreeNode(7);
       tr1.left = tr2;
       tr1.right = tr3;
       tr2.left = tr4;
       tr2.right = tr5;
       tr3.left = tr6;
       tr3.right = tr7;
       FindPath(tr1,7);
   }
   private static ArrayList<ArrayList<Integer>> listAll = new ArrayList();
   private static ArrayList<Integer> list = new ArrayList();
   public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
       if(root == null) return listAll;
       list.add(root.val);
       target -= root.val;
       if(target == 0 && root.left== null && root.right == null)
           listAll.add(new ArrayList<Integer>(list));
       FindPath(root.left,target);
       FindPath(root.right,target);
       list.remove(list.size() - 1);
       return listAll;
    }

//   public static void printFromTop(TreeNode node){
//       int i = Depth(node,0);
//   }
//
//   public static void print(TreeNode root,int level,ArrayList<Integer> list){
//       if(root == null || level < 1){
//           return ;
//       }
//       if( 1 == level){
//           list.add(root.val);
//           return;
//       }
//       print(root.left,level - 1 ,list);
//       print(root.right,level - 1,list);
//   }
//
//   public static int Depth(TreeNode treeNode,int depth){
//       if(treeNode == null){
//           return depth;
//       }
//       depth++;
//       return Depth(treeNode.left,depth) >= Depth(treeNode.right,depth) ? Depth(treeNode.left,depth) : Depth(treeNode.right,depth);
//   }
}

