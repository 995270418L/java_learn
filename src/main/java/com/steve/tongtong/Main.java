package com.steve.tongtong;

import java.util.Scanner;

public class Main {


    public String afterNDays(String srcDate, int n){
        String[] dataStr = srcDate.split("-");
        int day = Integer.valueOf(dataStr[2]); // 天
        int month = Integer.valueOf(dataStr[1]); // 月
        int year = Integer.valueOf(dataStr[0]);

        // 获取当前月的总天数
        int currentDaysOfMonth = currentDaysOfMonth(year, month);
        if( n > (currentDaysOfMonth - day)) { // 如果输入的时间大于当前月的总时间
            if(month == 12){
                year += 1;
                month = 1;
            }else{
                month += 1;
            }
            return afterNDays(year + "-" + month + "-" + 0, n - (currentDaysOfMonth - day));
        }else{
            day += n;
        }
        return year + "-" + month + "-" + day;
    }

    private int currentDaysOfMonth(int years, int month){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if(years % 4 == 0 && years % 100 !=0 || years % 400 == 0) // 判断闰年的条件。
                return 29;
                else
                    return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                System.out.println("输入不正确");
                System.exit(1);  // 程序退出
        }
        return 0;
    }



    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = null;
        while(true){
            System.out.println("今天是2019-10-20号，求几天后的日期: ");
            scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            System.out.println(n + "天后的日期是： " + main.afterNDays("2019-10-20", n));
        }
    }

}
