package com.steve.cow_guest.typical;

/**
 * @Author: steve
 * @Date: Created in 9:35 2018/2/28
 * @Description: 判断一个字符串是否为有效的括号，即有开能闭 "(())" ---> true "()(" ---> false
 * 解决:
 *      加一个计数变量num，遇到左括号++，遇到又括号 --。当num < 0的时候返回false
 * @Modified By:
 */
public class Parentheses {

    public static void main(String[] args) {
        String source = "(abc))";
        System.out.println(source + " 是否为有效的括号字符串? " +ParenthesesString(source) );
    }

    private static boolean ParenthesesString(String source) {
        int num = 0;
        char[] strings = source.toCharArray();
        for(int i=0;i < strings.length; i++){
            if( strings[i] == '('){
                num ++ ;
            }
            if(strings[i] == ')'){
                num --;
            }
            if(num < 0){
                return false;
            }
        }
        if(num == 0){
            return true;
        }else {
            return false;
        }
    }
}
