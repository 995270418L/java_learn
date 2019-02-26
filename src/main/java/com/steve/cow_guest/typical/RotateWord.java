package com.steve.cow_guest.typical;

/**
 * @Author: steve
 * @Date: Created in 21:17 2018/2/26
 * @Description: 旋转词，将字符串中的字符后移后形成的新字符称为原字符的旋转词 例如1234 和4321，3421，2341 互为旋转词
 * 解决:
 *      将原字符copy一份相加得到新字符串，再用 KMP 算法判断待比较的字符串是否是新字符串的字串。
 * @Modified By:
 */
public class RotateWord {

    public static void main(String[] args) {
        String s1 = "1234",s2 = "2134";
        String s1_plus = s1 + s1;
        System.out.println(kmp(s1_plus,s2));
    }

    static int kmp(String s,String pattern){
        int i=0,j=0;
        int slen = s.length();
        int plen = pattern.length();
        // 部分匹配值保存在这个数组里面
        int[] next = new int[plen];
        // 得到待搜索词的部分匹配值
        getNext(pattern,next);

        while(i<slen && j < plen){
            if(s.charAt(i) == pattern.charAt(j)){
                i++;j++;
            }else{
                if(next[j] == -1){
                    i++;
                    j = 0;
                }else{
                    j = next[j];
                }
            }
            if(j == plen){
                return i-j;
            }
        }
        return -1;
    }

    /**
     * 求next数组，为相同前缀后缀的数目右移，首位设为-1
     * @param pattern
     * @param next
     */
    private static void getNext(String pattern, int[] next) {
        int plen = pattern.length();
        next[0] = -1;
        int k = -1,j = 0;
        while(j < plen - 1){
            // pattern.charAt(k)表示前缀， pattern.charAt(j)表示后缀
            if(k == -1 || pattern.charAt(j) == pattern.charAt(k)){
                ++ j;
                ++ k;
                if(pattern.charAt(j) != pattern.charAt(k)){
                    next[j] = k;
                }else{
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
                }
            }else{
                k = next[k];
            }
        }
    }

}
