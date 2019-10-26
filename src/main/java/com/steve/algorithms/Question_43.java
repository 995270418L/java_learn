package com.steve.algorithms;

/**
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"4
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */
public class Question_43 {

    /**
     * 暴力枚举 竖式相乘法
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String res = "0";
        for(int i=num1.length() - 1; i >= 0; i--){
            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            for(int j=num1.length()-1; j >i; j--){
                sb.append("0"); // 补 0
            }
            for(int j=num2.length()-1; j >= 0 || carry != 0; j--){
                int n2 = j >=0 ? num2.charAt(j) - '0' : 0;
                int sum = ( n1 * n2 + carry ) % 10;
                sb.append(sum);
                carry = (n1 * n2 + carry) / 10;
            }
            res = add(res, sb.reverse().toString());
        }
        return res;
    }

    /**
     * 字符串相加
     * @param num1
     * @param num2
     * @return
     */
    public String add(String num1, String num2){
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=num1.length()-1,j=num2.length()-1; i>=0 || j>=0 || flag != 0; i--, j--){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0 ;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0 ;
            int sum = (n1 + n2 + flag) % 10;
            sb.append(sum);
            flag = (n1 + n2 + flag) / 10;
        }
        return sb.reverse().toString();
    }

    /**
     *  num1 * num2 的结果的最大长度是 [num.length + num2.length],
     *  num1[i] * num2[j] 的结果只能是两位数 “0x” 或者 “xy”, 第一位的位置为 i + y; 第二位的位置为 i + y + 1;
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multipy2(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for(int i=num1.length() -1; i>=0; i--){
            int n1 = num1.charAt(i) - '0';
            for(int j=num2.length()-1; j>=0; j--){
                int n2 = num2.charAt(j) - '0';
                int mul = res[i+j+1] + n1 * n2;             // 只有 i+j+1 的index会发生进位
                res[i+j] += mul / 10;
                res[i+j+1] = mul % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(int i=0; i< res.length; i++){
            if(res[i] != 0 || !first){
                sb.append(res[i]);
                first = false;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Question_43 question = new Question_43();
        System.out.println(question.multipy2("22", "21"));
    }

}
