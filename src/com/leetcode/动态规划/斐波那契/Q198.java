package com.leetcode.动态规划.斐波那契;

public class Q198 {
    /**
     * 可以空间优化，用两个变量来表示
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        else if (len == 2)
            return Math.max(nums[0], nums[1]);
        else if (len == 0)
            return 0;


        int[] dp = new int[len + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[len];
    }
}
