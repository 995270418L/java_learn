package com.steve.cow_guest.typical;

/**
 * @Author: steve
 * @Date: Created in 9:19 2018/2/28
 * @Description: 字符串中指定字符替换，例如 "a b c"中空格替换成 %20
 * 解决:
 *      首先盘判断字符串中有多少个空格，进而得出新字符串的长度，这里是5 + 2*2 = 9
 *      然后从后面开始遍历,当遇到空格时填充 %20 三个字符即可
 * @Modified By:
 */
public class StringReplace {

    public static void main(String[] args) {
        String source = "a b c";
        int len = blankSpace(source);
        String result = fillString(source.toCharArray(), len);
        System.out.println(result);
    }

    private static String fillString(char[] chars, int len) {
        char[] result = new char[len];
        for(int i = chars.length -1,j = 1; i>=0 ;i --){
            if(chars[i] != ' '){
                result[len - j] = chars[i];
                j ++ ;
            }else{
                result[len - j] = '0';
                j++ ;
                result[len - j] = '2';
                j++ ;
                result[len - j] = '%';
                j++ ;
            }
        }
        return new String(result);
    }

    private static int blankSpace(String source) {
        char[] strings = source.toCharArray();
        int count = 0 ;
        for(int i=0;i<strings.length;i++){
            if(strings[i] == ' '){
                count ++;
            }
        }
        return strings.length + count*2;
    }
}
