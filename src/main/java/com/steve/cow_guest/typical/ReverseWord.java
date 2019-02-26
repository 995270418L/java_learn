package com.steve.cow_guest.typical;

/**
 * @Author: steve
 * @Date: Created in 19:46 2018/2/27
 * @Description: 给单词做逆序处理 “pig loves dog” --->> "dog loves pig"
 * @Modified By:
 */
public class ReverseWord {

    public static void main(String[] args) {
        String source = "pig loves dog";
        String firstR = reverse(source);
        String[] split = firstR.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s:split){
            sb.append(reverse(s));
            sb.append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

    /**
     * 转换函数: 将字符串逆序排列
     * @param source
     * @return
     */
    static String reverse(String source){
        char[] s = source.toCharArray();
        int len = s.length;
        char tmp ;
        for(int i=0;i < len / 2 ; i++){
            tmp = s[i];
            s[i] = s[len - i -1];
            s[len -i -1] = tmp;
        }
        return new String(s);
    }
}
