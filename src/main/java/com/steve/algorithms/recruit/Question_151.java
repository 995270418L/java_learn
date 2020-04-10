package com.steve.algorithms.recruit;

/**
 * 面试40: 最小的k个数
 */
public class Question_151 {

    public static void main(String[] args) {
        Question_151 question = new Question_151();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        System.out.println(question.reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        if (s.trim().equalsIgnoreCase("")) return "";
        String[] strSpit = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strSpit.length - 1; i >= 0; i--) {
            if (strSpit[i].equals("")) continue;
            sb.append(strSpit[i]);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

}
