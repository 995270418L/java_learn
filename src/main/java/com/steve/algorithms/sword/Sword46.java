package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;


public class Sword46 {

  public static void main(String[] args) {
    Sword46 sword14 = new Sword46();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
    int[] arr = new int[]{3,30,34,5,9};
    System.out.println(sword14.translateNum(12258));
  }

  /**
   * dp[i] 表示第 i 位数字的位置有多少种翻译方法
   *
   * dp[i] = dp[i-1] + dp[i-2] && 10 <= nums[i-1 ... i] <= 25
   *
   * 122  3 种
   * @param num
   * @return
   */
  public int translateNum(int num) {
    return helper(num + "");
  }

  public int helper(String s){
    if(s.length() >= 2) {
      int[] dp = new int[s.length()];
      dp[0] = 1;
      dp[1] = between10_25(s.substring(0,2)) ? 2 : 1;
      for(int i=2; i<s.length(); i++){
        dp[i] = dp[i-1];
        if(between10_25(s.substring(i-1,i+1))){
          dp[i] += dp[i-2];
        }
      }
      return dp[s.length()-1];
    }else{
      return s.length() == 1 ? 1 : s.compareTo("25") > 0 ? 1 : 2;
    }
  }

  public boolean between10_25(String s){
    return Integer.parseInt(s.substring(0,2)) <= 25 && Integer.parseInt(s.substring(0,2)) >= 10;
  }

}
