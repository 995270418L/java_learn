package com.steve;


import com.steve.ifeve.Reflection.DynamicReflection.AnInterface2;
import com.steve.ifeve.Reflection.DynamicReflection.MyObjectSupperClass;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Main extends MyObjectSupperClass implements AnInterface2 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("input num1:");
//        int num1 = sc.nextInt();
//        System.out.println("input num2:");
//        double num2 = sc.nextDouble();
//        switch(num1){
//            case 0:{
//                if(num2 <1000){
//                    System.out.println("num2 < 1000");
//                }else if( num2 < 2000 && num2 >1000){
//                    System.out.println("num2 < 2000");
//                }else {
//                    System.out.println(num2);
//                }
//                break;
//            }
//            case 2 : {System.out.println("num1 == " + num1);break;}
//            default :
//                System.out.println("num1 error");
//        }
//
//    }

//    public static void main(String... args){
//        Map<String,String> map = new HashMap();
//        Map<String,String> table = new Hashtable();
//        AtomicInteger atomic = new AtomicInteger(1);
//
//    }

//    public static void main(String... args){
//        List<String> list = new ArrayList<>();
//        list.add("demo1");
//        list.add("demo2");
//        list.add("demo3");
//
//        Iterator<String> iterator = list.iterator();
////        iterator.remove();   //直接删除会报错，应为此时next坐标位于第一个元素前面，此时为空
//
//        iterator.next();
//        iterator.remove();    //此时next位于第一个元素后面，调用remove方法删除第一个元素
//    }

//    ArrayList<String> list = new ArrayList<>();
//    public static void main(String... args){
//        Main main = new Main();
//        String string = "abc";
//        String result = main.reverse(string.toCharArray(),1,2);
//        System.out.println(result);
//        main.list.add(string);
//        while(true){
//            boolean isOk = main.calc(main.list.get(main.list.size()-1).toCharArray(),3);
//            if(!isOk){
//                break;
//            }
//        }
//        for(String str : main.list){
//            System.out.println(str);
//        }
//    }

//    public void calc(char[] perm,int from,int to){
//        if(to <= 1){
//            return;
//        }
//
//        if(from == to){
//            for(int i=0;i<= to;i++){
//                System.out.print(perm[i]);
//            }
//            System.out.println();
//        }else{
//            char tmp = '0';
//            for(int j= from;j <= to;j++){
//                tmp = perm[j];
//                perm[j] = perm[from];
//                perm[from] = tmp;
//                calc(perm,from+1,to);
//                tmp = perm[j];
//                perm[j] = perm[from];
//                perm[from] = tmp;
//            }
//        }
//    }

//    public boolean calc(char[] perm,int num){
//        int i;
//        //首先找到最后一个正序
//        for(i = num - 2 ; (i >= 0) && (perm[i] >= perm[i+1]);i--);
//        //得到最后一个正序i的位置
//        //判断i是否大于０，若不大于０，则没有比他更小的了
//        if(i < 0) return false;
//        int k;  //比i大的最后一个字符
//        for(k = num - 2 ; (k > i) && (perm[k] <= perm[i]); k--);
//        //交换这两个字符的位置
//        char tmp;
//        tmp = perm[k];
//        perm[k] = perm[i];
//        perm[i] = tmp;
//
//        //将i字符开始的位置进行升序排序
//        list.add(reverse(perm,k,perm.length));
//        return true;
//    }
//
//    public String reverse(char[] perm,int start,int end){
//        String need = perm.toString().substring(start).toString();
//        Arrays.sort(need.toCharArray());
//        return perm.toString().substring(0,start).toString() + need;
//    }

    // 基于CurrentHashMap 和 lambda实现本地缓存 (没有缓存)
//    public static int fabonacci(int i){
//        if(i == 1 || i ==0){
//            return 1;
//        }
//        System.out.println("Canculate: " + i);
//        // 没有实现缓存的计算
//        return fabonacci(i -1) + fabonacci( i -2 );
//    }
//
//    static Map<Integer, Integer> cache = new ConcurrentHashMap<>();
//    // 缓存
//    public static int fabonacci(int i){
//        if(i == 1 || i ==0){
//            return 1;
//        }
//        // 如果对应于　i 的value不存在的时候，　会计算这个value的值，从而实现高速缓存
//        return cache.computeIfAbsent(i, (key) -> {
//           System.out.println("Canculate: " + key);
//
//           return fabonacci(key - 1) + fabonacci(key - 2);
//        });
//    }
//
//    public static void main(String... args){
//        for(int i=0; i< 10; i++) {
//            System.out.println("f (" + i + ") = " + fabonacci(i));
//        }
//    }

    public static void main(String... args) throws IOException {

//        FileInputStream inputStream = new FileInputStream("/home/liu/Desktop/chinese.txt");
//        int count = 0;
//        int a = inputStream.read();
//        while(a != -1){
//            count ++;
//            a = inputStream.read();
//        }
//        System.out.println(count);
//        inputStream.close();
//        Scanner sc = new Scanner(System.in);
//
//        Map<String,String> map = new ConcurrentHashMap<>();
//        Map<String,String> hashMap = new HashMap();
//        ReentrantLock lock = new ReentrantLock();
//        Object o = new Object();
//        new Main().echo();

    }

    public synchronized void echo(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
