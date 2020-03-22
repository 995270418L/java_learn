package com.steve.algorithms.recruit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 945. 使数组唯一的最小增量
 *
 */
public class Question_945 {

    public int minIncrementForUnique(int[] A) {
        if(A.length == 0) return 0;
        Arrays.sort(A);
        int res = 0;
        for(int i=1; i<A.length; i++){
            while (A[i] <= A[i-1]){
                A[i] ++;
                res ++;
            }
        }
        return res;
    }

    /**
     * 超出时间限制
     * @param A
     * @return
     */
    public int minIncrementForUnique2(int[] A) {
        if(A.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i=0; i<A.length; i++){
            while (!set.add(A[i])){
                A[i] += 1;
                res ++;
            }
        }
        return res;
    }

    /**
     * 计数法, slow than method 1
     * @param A
     * @return
     */
    public int minIncrementForUnique3(int[] A) {
        if(A.length == 0) return 0;
        int[] calc = new int[80000];
        int res = 0;
        for(int i=0; i<A.length; i++){
            calc[A[i]] ++ ;
        }
        for(int i=0; i<calc.length; i++){
            while (calc[i] > 1){
                int moveVal = i + 1;
                calc[moveVal] ++;
                calc[i] --;
                res ++;
            }
        }
        return res;
    }

    /**
     * 优化方法，先减去重复的数的总和，再加上没重复的数大小
     * @param A
     * @return
     */
    public int minIncrementForUnique4(int[] A) {
        if(A.length == 0) return 0;
        int[] calc = new int[80000];
        int res = 0;
        int repeat = 0;
        for(int i : A) calc[i] ++;
        for(int i=0; i<calc.length; i++){
            if(calc[i] > 1){
                repeat += (calc[i] - 1) ;
                res -= i * (calc[i] - 1);
            }else if(repeat > 0 && calc[i] == 0){
                repeat --;
                res += i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question_945 question = new Question_945();
        int[] arr = {2,2,2,1};
        System.out.println(question.minIncrementForUnique4(arr));
    }

}
