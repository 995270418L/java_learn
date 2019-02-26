package com.steve.cow_guest.typical.dp;

/**
 * @Author: steve
 * @Date: Created in 11:19 2018/3/4
 * @Description: 动态递归的aim money问题，给定一定面值的货币，求组成aim money 的方法总数
 * 解决:
 *     三种解决方案，暴力搜索 ---> 记忆搜索  ---> 动态规划
 * @Modified By:
 */
public class DpAimMoney {

    public static void main(String[] args) {
        int[] source = {5, 1, 10, 20};
        int aim = 1000;
        System.out.println("方法总数: " + new DpAimMoney().solve(source,aim));
    }

    private int solve(int[] source, int aim) {
        if(source == null || source.length == 0 || aim < 0){
            return 0;
        }
        // 暴力搜索实现
//        return violence(source,0,aim);

        // 记忆搜索
//        int[][] map = new int[source.length + 1][aim+1];
//        return memory(source,0,aim,map);

        // 动态递归方法实现
        int[][] dp = new int[source.length][aim + 1];
        return dpm(source,aim,dp);
    }

    // 暴力搜索
    private int violence(int[] source, int index, int aim) {
        int res = 0;  // 方案总数
        if(index == source.length){
            res = aim == 0 ? 1 : 0; // aim 为 0 表示这种方案可行，所以res = 1; 结果累加即可
        }else{
            for(int i = 0; source[index] * i <= aim ; i++){
                // 固定一种货币情况下的递归函数求计算总数
                res += violence(source,index + 1, aim -  source[index] * i);
            }
        }
        return res;
    }

    // 记忆搜索
    private int memory(int[] source, int index, int aim, int[][] map){
        int res = 0;
        if(index == source.length){
            res = aim == 0 ? 1 : 0;
        }else{
            int mapValue = 0;
            for(int i=0 ; source[index] * i <= aim ; i ++){
                mapValue = map[ index + 1 ][aim - source[index] * i ];
                if(mapValue != 0){
                    res += mapValue == -1 ? 0 : mapValue;
                }else {
                    res += memory(source, index + 1 , aim - source[index] * i, map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    /**
     * 动态递归方法的实现，dp大小为
     * @param source
     * @param aim
     * @param dp
     * @return
     */
    private int dpm(int[ ] source, int aim, int[][] dp){
        dp[0][0] = 1;
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
            for(int j=1;j<dp[0].length;j++){
                if( i == 0 ){
                    dp[i][j] = (j % source[i] == 0) ? 1 : 0;
                }else{
                    // i > 0
//                    for(int k = 0; k <= aim / source[i] && (j - source[i] * k) >= 0; k++){
//                        dp[i][j] += dp[i-1][j - source[i]*k ];
//                    }
                    dp[i][j] = dp[i-1][j];
                    dp[i][j] += (j - source[i] >= 0) ? dp[i][j - source[i]] : 0 ;
                }
            }
        }
        return dp[source.length - 1][aim];
    }
}
