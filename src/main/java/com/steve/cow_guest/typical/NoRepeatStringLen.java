package com.steve.cow_guest.typical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: steve
 * @Date: Created in 10:23 2018/2/28
 * @Description: 判断字符串中最长的无重复字串长度 “abcd” --> "abcd" 4 ;;; "abca"  ----> "abc" 3
 * 解决：
 *
 * @Modified By:
 */
public class NoRepeatStringLen {

    public static void main(String[] args) {
        String source = "abcd";
        // dp 方案
        System.out.println("最长字串的长度为: " + dpHashLen(source));
    }

    /**
     * 对于最长不重复子串，某个当前的字符，如果它与前面的最长不重复子串中的字符没有重复，那么就可以以它为结尾构成新的最长子串；
     * 如果有重复，且重复位置在上一个最长子串起始位置之后，那么就与该起始位置之后的稍短的子串构成新的子串或者单独成一个新子串。
     * 我们首先使用O(n^2)的DP方案：在内层循环遍历到上一个最长子串的起始位置。
     * @param source
     * @return
     */
    private static int dpLens(String source) {
        if(source == null){
            return 0;
        }
        // lastIndex 为上次无重复子串的最长长度的位置
        int maxLen = 0,lastIndex = 0;
        // 记录每个字符到最左边的最长子串长度
        int[] dp = new int[source.length()];
        dp[0] = 1;
        for(int i = 1; i<source.length(); i++){
            for(int j = i-1; j>= lastIndex; j--){
                if(source.charAt(i) == source.charAt(j)){
                    dp[i] = i - j; // 当前字符的最长子串长度为 1
                    lastIndex = j + 1;
                    break;
                // 当遍历到最左边没退出循环时，保存当前字符的最长子串长度
                }else if(j == lastIndex){
                    dp[i] = dp[i-1] + 1;
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 上面的DP方法依然是O(n^2)，因为每次我们都需要“回头”去寻找重复元素的位置。
     * 我们知道可以用hash记录元素是否出现过，这样就不必“回头”了，而时间复杂度必然降为O(N)，只不过需要额外的空间消耗。
     * @param source
     * @return
     */
    private static int dpHashLen(String source){
        if(source == null){
            return 0;
        }
        // lastIndex 为上次无重复子串的最长长度的位置
        int lastIndex = 0;
        int[] dp = new int[source.length()];
        dp[0] = 1;
        Map<Character, Integer> map = new HashMap();
        map.put(source.charAt(0),0);
        for(int i=1; i<source.length(); i++){
            // 不存在这个值
            if(map.get(source.charAt(i)) == null){
                dp[i] = dp[i-1] + 1;
                map.put(source.charAt(i),i);  //给这个字符做个hash标记location
            }else{
                // 如果存在，判断上次的最长无重复子串长度的位置是否在上次出现这个字符的位置里面
                // 在外面
                if(lastIndex <= map.get(source.charAt(i))){
                    dp[i] = i - map.get(source.charAt(i));
                    lastIndex = map.get(source.charAt(i));
                }else{
                    //在里面
                    dp[i] = dp[i-1] + 1;
                }
                map.remove(source.charAt(i));
                map.put(source.charAt(i),i);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
