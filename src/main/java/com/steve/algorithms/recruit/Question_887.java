package com.steve.algorithms.recruit;

/**
 * 887. 鸡蛋掉落
 */
public class Question_887 {

    public static void main(String[] args) {
        Question_887 question = new Question_887();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        System.out.println(question.superEggDrop(3, 14));
    }

    /**
     * 二分法，最坏的情况下，就是它都没碎。一直往上扔. 这种策略在 K= 1， N = 4 的时候答案出错。换种策略，DP
     *
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        if (K == 0) return 0;
        int left = 0, right = N, res = 0;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            left = mid + 1;
            if (mid == 0) continue;
            res++;
        }
        return res;
    }

}
