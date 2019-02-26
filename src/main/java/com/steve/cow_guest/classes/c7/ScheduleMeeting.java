package com.steve.cow_guest.classes.c7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 安排会议，求哪种安排方案能安排较多的会议场数。
 *  两个数组，一个是表示会议的开始时间，一个表示会议的结束时间。
 * 一个贪心策略是：根据会议的时间，那个会议的时间短就安排哪个会议。
 * 一个贪心策略是：哪个会议先开始就安排哪个会议。
 * 正确的贪心策略： 以上两种都有明显的错误，并不能得到正确的结果。应该以哪个会议的结束时间早来贪心的。
 * 用小根堆，最早结束的放在堆顶。
 */
public class ScheduleMeeting {

    public static class Program{
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class TimeComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int dealProgram(Program[] programs,int meet){
        PriorityQueue<Program> pq = new PriorityQueue<>(new TimeComparator());
        for(Program program : programs){
            pq.add(program);
        }
        int res = 0;
        Program meeting;
        while (!pq.isEmpty()){
            meeting = pq.poll();
            if(meeting.start >= meet){
                res ++;
                meet = meeting.end;
            }
        }
        return res;
    }

    public static int constructData(int[] start, int[] end){
        Program[] p = new Program[start.length];
        for(int i=0; i< start.length ;i++){
            p[i] = new Program(start[i],end[i]);
        }
        return dealProgram(p,Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        int[] start = {6,8, 11, 14,16,18};
        int[] end = {9,10,12,17,18,20};
        int count = constructData(start,end);
        System.out.println(count);
    }

}
