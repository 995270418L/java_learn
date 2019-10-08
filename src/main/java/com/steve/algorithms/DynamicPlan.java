package com.steve.algorithms;

public class DynamicPlan {

    public static void main(String[] args) {
        int[] p = {1,2, 5, 10,20};
//        System.out.println(test1(p));
//        System.out.println(test4(p, 4));
        System.out.println(test5(p));
    }


    public static int test5(int[] p){
        int[] dp = new int[p.length];
        dp[0] = p[0];
        dp[1] = p[1];
        dp[2] = p[0] + p[1] + p[2];
        for(int i = 3; i<p.length; i++){
            dp[i] = p[0] + p[1]*2 + p[i] + dp[i - 2];
        }
        return dp[p.length-1];
    }

    /**
     *  no dp 仅仅是递推
     * @param T
     * @param n
     * @return
     */
    public static int test4(int[] T, int n){
        if(n<=2) return T[n];
        if(n == 3) return T[1]+T[2]+T[3];
        int f_n2 = T[2]; //f(n-2)
        int f_n1 = T[1]+T[2]+T[3];//f(n-1)
        int f_n = 0;
        for(int i = 4; i <= n; ++i)
        {
            f_n = T[1] + 2*T[2] + T[i] + f_n2;
            f_n2 = f_n1;
            f_n1 = f_n;
        }
        return f_n;
    }

    /**
     * 区间模型： 线性模型. 过桥问题
     * 假设p是排好序的，则通式为： 重叠问题, 第i个人过桥，两种情况， 一个人过桥，两个人过桥, 不能理解的是为什么这里要取这两种情况中的最小值
     *    dp[i] = dp[i-1] + p[0] + p[i]
     *    dp[i] = dp[i-2] + p[0] + 2*p[1] + p[i]
     * @param p 花费时间排序的
     * @return
     */
    public static int test3(int[] p){
        int[] dp = new int[p.length];
        dp[0] = p[0];
        dp[1] = p[1];
        for(int i=2; i<p.length ;i++){
            int min = Math.min(dp[i-1]+ p[0] + p[i], dp[i-2] + p[0] +p[1]*2 + p[i]);
            dp[i] = min;
        }
        return dp[p.length - 1];
    }

    /**
     * 这个问题是 Rn = Pi + R(n-i)
     * @param p
     * @return
     */
    public static int test2(int[] p){
        int n = p.length;
        int[] r = new int[n+1];
        for(int i=1; i<= p.length; i++){
            int q = -2;
            for(int j=1 ; j <= i; j++){
                q = Math.max(q, r[i - j] + p[j -1]);   // 求的是 r[n] 的最优解
            }
            r[i] = q;
        }
        return r[p.length];
    }

    /**
     * n 长度的钢条和 p 类型的价格表
     * 自顶而下 备忘录法
     * @param p
     */
    public static int test1(int[] p){
        int[] dp = new int[p.length + 1];
        for(int i=0; i <= p.length ;i ++){
            dp[i] = -1;
        }
        return cut(p, p.length, dp);
    }

    private static int cut(int[] p, int n, int[] dp) {
        int max = -1;
        if(dp[n] > -1){
            return dp[n];
        }
        if(n == 0){
            max = 0;  // 不切割的话，默认就是 Pn 的价格，所以这里为0
        } else {
            for(int i=1; i <= n; i++){
                max = Math.max(max, cut(p, n - i, dp) + p[i-1]);
            }
        }
        dp[n] = max;
        return max;
    }
}
