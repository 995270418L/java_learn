package com.steve.cow_guest;


import java.util.*;
import java.util.Scanner;

/**
 * Created by liu on 3/19/17.
 */
public class  Main2 {

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            double num = sc.nextDouble();
//            int max = (int) Math.sqrt(num);
//            boolean isHave = false;
//            for(int j=max,i=2;j>1;j--) {
//                if (ss(j)) {
//                    if (Math.pow(j, i) == num) {
//                        System.out.println(j + " " + i);
//                        isHave = true;
//                        break;
//                    }else if(Math.pow(j,i) < num){
//                        i++;
//                    }
//                }
//            }
//            if(!isHave){
//                System.out.println("NO");
//            }
//        }
//    }
//    static boolean ss(int num){
//        if(num < 2){
//            return false;
//        }else{
//            for(int i=2;i<Math.sqrt(num);i++){
//                if(num % i == 0){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String line = sc.nextLine();
//            int num = Integer.valueOf(line.split(" ")[0]);
//            int start = Integer.valueOf(line.split(" ")[1]);
//            Map<Integer,int[]> map = new HashMap();
//            List<Integer> list = new ArrayList();
//            int tmp = 0;
//            int i = start;
//            while(start < num){
//                tmp += i;
//                list.add(i);
//                i++;
//                if(tmp > num){
//                    start ++ ;
//                    tmp = 0;
//                    list.clear();
//                    i = start;
//                }else if(tmp == num){
//                    int[] a = new int[list.size()];
//                    for(int j=0;j<list.size();j++){
//                        a[j] = list.get(j);
//                    }
//                    map.put(list.size(),a);
//                    start ++ ;
//                    //清空list信息
//                    list.clear();
//                    tmp =0;
//                }
//            }
//            int min = 100000000;
//            for(Map.Entry<Integer,int[]> entry : map.entrySet()){
//                if(entry.getKey() < min){
//                    min = entry.getKey();
//                }
//            }
//            int[] a = map.get(min);
//            StringBuilder sb = new StringBuilder();
//            for(Integer b : a){
//                sb.append(b).append(" ");
//            }
//            System.out.println(sb.substring(0,sb.length()-1).toString());
//        }
//    }

    static int n = 4, l = 25,p = 10;
    static int[] a = {10,14,20,21,0};
    static int[] b = {10,5,2,4,0};
    public static void main(String... args){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans=0; //加油次数 (从队列中取出b的次数)
        int pos = 0;  //当前的位置
        int task = p;   //油量剩余
        for(int i=0;i<n;i++){
            int distance = a[i] - pos;  //接下来要前进的距离
            //如果油不够了就一直加加到慢了为止
            while(task - distance < 0){
                //油不够了
                if(queue.isEmpty()){
                    System.out.println("-1");
                    break;
                }
                task += queue.peek();   //retrieve but don't remove
                queue.poll();   //remove
                ans++;
            }
            task -= distance;
            pos = a[i];
            queue.add(b[i]);
        }
        System.out.println(ans);
    }
}
