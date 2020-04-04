package com.steve.algorithms.recruit;

/**
 * 面试40: 最小的k个数
 */
public class Question_8 {


    public static void main(String[] args) {
        Question_8 question = new Question_8();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int target = question.myAtoi("+-2");  // -2147483648
        System.out.println(target);
    }

    /**
     * 字符串转数字
     * 自动状态机的算法
     * 1. start  ' '
     * 2. sign  '+' || '-'
     * 3. in_num  0 <= value < 10
     * 4. end value < 0 || value >= 19
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int state = 1;
        int res = 0;
        boolean minus = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int value = c - '0';
            if (c == ' ' && state == 1) {
                continue;
            } else if ((c == '-' || c == '+') && state == 1) {
                state = 2;
                minus = c == '-';
                continue;
            } else if (value >= 0 && value < 10 && state <= 3) {
                state = 3;
                if (res >= Integer.MAX_VALUE / 10) {
                    int left = res - Integer.MAX_VALUE / 10;
                    if (left > 0) return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    if (minus) {
                        if (value > 8) return Integer.MIN_VALUE;
                    } else {
                        if (value >= 8) return Integer.MAX_VALUE;
                    }
                }
                res = res * 10 + value;
            } else if (state >= 3 && (value < 0 || value > 10)) {
                return minus ? -res : res;
            } else {
                return 0;
            }
        }
        return minus ? -res : res;
    }

}
