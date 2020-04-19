package com.steve.algorithms.company.bytedance;

/**
 * 字符串相乘
 */
public class CharacterMultiply {

    private String res = "0";

    public static void main(String[] args) {
        CharacterMultiply cm = new CharacterMultiply();
        System.out.println(cm.multiply("2", "38"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        helper(num1, num2, num2.length() - 1);
        return res;
    }

    public void helper(String num1, String num2, int idx) {
        if (idx < 0) return;
        int val = num2.charAt(idx) - '0';
        int i = num1.length() - 1, flag = 0, count = 0;
        StringBuilder tmp = new StringBuilder();
        while (i >= 0 || flag > 0) {
            StringBuilder sb = new StringBuilder();
            int mul = i >= 0 ? num1.charAt(i) - '0' : 0;
            int value = mul * val + flag;
            flag = value / 10;
            sb.append(value % 10);
            for (int j = 0; j < count; j++) {
                sb.append(0);
            }
            count++;
            i--;
            tmp = new StringBuilder(add(tmp.toString(), sb.toString()));
        }
        for (int j = idx; j < num2.length() - 1; j++) {
            tmp.append(0);
        }
        res = add(res, tmp.toString());
        helper(num1, num2, idx - 1);
    }

    /**
     * 字符串相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public String add(String num1, String num2) {
        int flag = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || flag > 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + flag;
            flag = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

}
