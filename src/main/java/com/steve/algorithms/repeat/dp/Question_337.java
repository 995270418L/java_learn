package com.steve.algorithms.repeat.dp;


import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question_337 {

    /**
     * 先序遍历转成数组，然后再回到198的问题的解法
     * @return
     */
    public int rob(TreeNode root) {
        int[] nums = beforeTravese(root);
        return robN(nums, 0, nums.length);
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    private int[] beforeTravese(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        System.out.println(res);
        int[] nums = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            nums[i] = res.get(i);
        }
        return nums;
    }

    public int robN(int[] nums, int start, int end) {
        int[] dp = new int[end];
        for(int i=start; i<end; i++){
            if(i == start){
                dp[i] = nums[start];
            }else if(i == (start + 1)){
                dp[i] = Math.max(dp[i-1], nums[i]);
            }else{
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        return nums.length == 1 ? nums[0] : dp[end - 1];
    }

    public static void main(String[] args) {
        Question_337 question = new Question_337();
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(1);

        root.left = left1;
        root.right = right1;

        left1.right = left2;
        right1.right = right2;

        int res = question.rob(root);
        System.out.println(res);
    }

}
