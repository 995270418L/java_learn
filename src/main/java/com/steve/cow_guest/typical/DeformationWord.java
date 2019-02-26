package com.steve.cow_guest.typical;

/**
 * @Author: steve
 * @Date: Created in 17:30 2018/2/26
 * @Description: 当两个字符串中每个字符出现的频次都相等时，称这两个字符串为变形词
 * 解决：
 *      给每个字符串中的每个字符做哈希表，最后判断哈希表是否相等。
 *      哈希表在java里面可以用一个长度为( 2 << 8 )的数组代替。更快
 * @Modified By:
 */
public class DeformationWord {

    public static void main(String[] args) {
        String s1 = "ab",s2 = "abb";
        System.out.println("这两个字符串是否相等: " + judgeEquals(s1,s2));
    }

    private static boolean judgeEquals(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        int[] hash1 = new int[2 << 16]; // 一个中文两个字节 2 * 8 = 16位，总大小就是 2^16 -1,这里还要+1 即2 << 16
        char[] char2 = s2.toCharArray();
        if(char1.length != char2.length){
            return false;
        }
        for(int i=0; i<char1.length; i++){
            hash1[char1[i]] ++ ;
        }
        for(int i=0; i<char2.length; i++){
            if(hash1[char2[i]] == 0){
                return false;
            }
            hash1[char2[i]] -- ;
        }
        return true;
    }

}
