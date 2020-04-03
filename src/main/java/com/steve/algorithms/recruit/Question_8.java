package com.steve.algorithms.recruit;

/**
 * 面试40: 最小的k个数
 */
public class Question_8 {

    public static void main(String[] args) {
        Question_8 question = new Question_8();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int target = question.myAtoi("-2147483649");  // -2147483648
        System.out.println(target);
    }

    /**
     * 字符串转数字
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        boolean minus = false, start = false;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int value = c - '0';
            if (start) {
                if (value > 10 || value < 0) return minus ? -res : res;
            } else {
                if (c != ' ' && c != '-' && c != '+' && (value > 10 || value < 0)) return minus ? res : res;
            }
            if (c != ' ') {
                start = true;
                if (c == '+') continue;
                if (c == '-') {
                    minus = true;
                    continue;
                }
                if (res >= Integer.MAX_VALUE / 10) {
                    if (minus) {
                        if (Integer.MAX_VALUE / res > value) {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        if (Integer.MAX_VALUE / res >= value) {
                            return Integer.MAX_VALUE;
                        }
                    }
                }
                res = res * 10 + value;
            }
        }
        return minus ? -res : res;
    }

}
