package com.steve.algorithms.repeat.backtrack;

/**
 * 累加数
 * <p>
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 */
public class Question_306 {


    private Boolean res = false;

    public static void main(String[] args) {
        Question_306 question = new Question_306();
        int[] arr = {1, 2, 3};
        System.out.println(question.isAdditiveNumber("0235813"));  // 112358
//        System.out.println(question.isAdditiveNumber("112358"));  // 112358
//        System.out.println(question.add("11","1"));  // 112358
    }

    public boolean isAdditiveNumber(String num) {
        int i = 0;
        for (int j = i + 1; j < num.length(); j++) {
            for (int k = j + 1; k < num.length(); k++) {
                if (dfs(i, j, k, num)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int k, String num) {
        if (k > num.length()) return false;
        if ((num.charAt(i) == '0' && j - i > 1) || (num.charAt(j) == '0' && k - j > 1)) return false; // 不能为 0 开头
        String a = num.substring(i, j);
        String b = num.substring(j, k);
        String sum = add(a, b);
        int n = sum.length();
        if ((k + n) > num.length() || !sum.equals(num.substring(k, k + n)))
            return false;  // 严格判断 false， 否则会往下走最后找到为 true 的 结果。不过这样可以改编一个问题，找到字符串的“累加和序列”。但是没啥意义
        if (k + n == num.length()) return true;
        return dfs(j, k, k + n, num);
    }


    /**
     * 字符串相加
     *
     * @param a
     * @param b
     * @return
     */
    public String add(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        while (i >= 0 || j >= 0) {
            int ti = i >= 0 ? a.charAt(i) - '0' : 0;
            int tj = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = ti + tj + (flag ? 1 : 0);
            flag = (sum / 10) >= 1;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (flag) sb.append(1);
        return sb.reverse().toString();
    }
}
