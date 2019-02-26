package com.steve.cow_guest.Demo2;

import java.util.*;

/**
 * Created by liu on 3/24/17.
 */
public class Demo {
//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int leastTime = 0;
//            int n = sc.nextInt();
//            int[] item = new int[n];
//            List<Integer> list = new ArrayList();
//            sc.nextLine();
//            String line = sc.nextLine();
//            String[] aa = line.split(" ");
//            for(int i=0;i<aa.length;i++){
//                list.add(Integer.valueOf(String.valueOf(aa[i])));
//            }
//            while(list.size() > 1){
//                int i=0;
//                //第一个小于最后一个
//                if(list.get(i) < list.get(list.size()-1)){
//                    int a = list.get(i);
//                    int b = list.get(i+1);
//                    list.set(i,a+b);
//                    list.remove(i+1);
//                    leastTime++;
//                }else if(list.get(i) > list.get(list.size()-1)){
//                    int a = list.get(list.size()-1);
//                    int b = list.get(list.size()-2);
//                    list.set(list.size()-2,a+b);
//                    list.remove(list.size()-2);
//                    leastTime++;
//                }else{
//                    list.remove(i);
//                    list.remove(list.size()-1);
//                }
//            }
//            System.out.println(leastTime);
//        }
//        sc.close();
//    }
//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int num = sc.nextInt();
//            String[] location = new String[4];
//            int c_walk = 0;
//            int c_taxi = 0;
//            for(int i=0;i<4;i++){
//                if(i ==0) sc.nextLine();
//                location[i] = sc.nextLine();
//            }
//            String[] x = location[0].split(" ");
//            String[] y = location[1].split(" ");
//            String[] loc = location[2].split(" ");
//            int x_min=Integer.valueOf(x[0]),y_min=Integer.valueOf(y[0]);
//            int x_loc = Integer.valueOf(loc[0]);
//            int y_loc = Integer.valueOf(loc[1]);
//            int x_0 = Math.abs(Integer.valueOf(x[0]));
//            int y_0 = Math.abs(Integer.valueOf(y[0]));
//            int min = x_0 + y_0;
//            for(int i=1;i<num;i++) {
//               int x_i = Integer.valueOf(x[i]);
//               int y_i = Integer.valueOf(y[i]);
//               if(min >= (Math.abs(x_i)+Math.abs(y_i))){
//                   if((x_loc - x_i) > (x_loc - x_min) || (y_loc - y_i) > (y_loc - y_min)){
//                       min = Math.abs(x_i) + Math.abs(y_i);
//                       x_min = x_i;
//                       y_min = y_i;
//                   }
//                }
//            }
//            c_walk = min;
//            c_taxi = Math.abs((x_loc - x_min)) + Math.abs((y_loc - y_min));
//            String[] wal = location[3].split(" ");
//            int walk = Integer.valueOf(wal[0]);
//            int taxi = Integer.valueOf(wal[1]);
//            System.out.println(c_walk*walk + c_taxi*taxi);
//        }
//    }

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String line = sc.nextLine();
//            int count =0;
//            int num = 0;
//            for(int i=line.length()-1;i>=0;i--){
//                if(line.charAt(i) == 'B'){
//                    count += (line.length()-i-1);
//                    num ++;
//                }
//            }
//            System.out.println(count - num + 1);
//        }
//    }
//
//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String[] line = new String[2];
//            for(int i=0;i<2;i++){
//                line[i] = sc.nextLine();
//            }
//            int num = Integer.valueOf(line[0].split(" ")[0]);
//            int cs = Integer.valueOf(line[0].split(" ")[1]);
//            String[] nums = line[1].split(" ");
//            int[] nums_i = new int[nums.length];
//            for(int i=0;i<nums.length;i++){
//                nums_i[i] = Integer.valueOf(nums[i]);
//            }
//            int head = 0;
//            while(cs-- > 0){
//                head = nums_i[0];
//                for(int i=0;i<num;i++){
//                    if(i == (num-1)){
//                        nums_i[i] += head;
//                    }else{
//                        nums_i[i] += nums_i[i+1];
//                    }
//                    if(nums_i[i] >=100){
//                        nums_i[i] = nums_i[i] % 100;
//                    }
//                }
//            }
//            StringBuilder sb = new StringBuilder();
//            for(int i=0;i<nums_i.length;i++){
//                sb.append(nums_i[i]).append(" ");
//            }
//            System.out.println(sb.toString().substring(0,sb.length()-1));
//        }
//    }

    public static void main(String... args){
        int i=10;
        int j =i++ % 5;
        System.out.println(i+ " " + j);
    }

}
