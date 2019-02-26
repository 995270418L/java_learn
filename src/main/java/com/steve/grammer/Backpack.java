package com.steve.grammer;

/**
 * Created by liu on 3/14/17.
 * 给定一定重量和价值的物品对，求给定重量下的物品的最大价值为多少(暴力搜索dfs)
 */
public class Backpack {

    static int[] w = {2,1,3,2};
    static int[] v = {3,2,4,2};
    static int aim = 5;   //目标重量<=5
    static int n = 4;     //有n对物品

    public static void main(String... args){
        long a = System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
//            System.out.println(res(0, aim));   //68ms
            res2();    //107ms
        }
        System.out.println("spent time: " + (System.currentTimeMillis() - a ));
    }

    /**
     *
     * @param i 第i件物品
     * @param j 剩余重量
     * @return 返回最大值
     */
    public static int res(int i, int j){
        int res = 0; //最大价值
        if(i == n){
            res = 0;    //当直接是第四件物品的时候,最大价值为0
        }else if(j < w[i]){
            //无法挑选这个物品,下一个!
            res = res(i+1,j);
        }else{
            //两种情况，一种是不加上这个物品，另一种是加上这个物品.
            res= Math.max(res(i+1,j),res(i+1,j-w[i])+v[i]);
        }
        return res;
    }

    /**
     * 通过使用记忆数组来快速得出结果
     * @param i 物品的数目
     * @param j 剩余的总重量
     * @return
     */
    public static void res2(){

        //定义一个记忆二维数组 长度都要大1

        int[][] dp = new int[n+1][aim+1];

        for(int i = n-1 ;i >= 0; i--){
            for(int j =0 ; j<= aim ; j++){
                if(j<w[i]) {
                    dp[i][j] = dp[i+1][j];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j-w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[0][aim]);
    }
}
