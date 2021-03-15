package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;

import java.util.Arrays;


public class Sword42 {

  public static void main(String[] args) {
    Sword42 sword14 = new Sword42();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
    int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(sword14.maxSubArrayDP(arr));
  }

  /**
   * 暴力枚举法
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {
    int ans = Integer.MIN_VALUE;
    for(int i=0;i<nums.length; i++){
      int tmp = nums[i];
      for(int j=i+1;j<nums.length; j++){
        tmp += nums[j];
        ans = Math.max(ans, tmp);
      }
    }
    return ans;
  }

  /**
   * dp[i] 表示 以 nums[i] 结尾的数和最大
   * 状态转移方程：
   *     if dp[i-1] < 0 dp[i] = nums[i]
   *     else if dp[i-1] > 0 && nums[i] > 0  dp[i] = dp[i-1] + nums[i]
   *     else dp[i-1] > 0 && nums[i] < 0 dp[i] = dp[i-1]
   *
   * @param nums
   * @return
   */
  public int maxSubArrayDP(int[] nums) {
    if(nums == null) return 0;
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int res = dp[0];
    for(int i=1;i<nums.length; i++){
      if(dp[i-1] < 0){
        dp[i] = nums[i];
      }else{
        dp[i] = dp[i-1] + nums[i];
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }

}
