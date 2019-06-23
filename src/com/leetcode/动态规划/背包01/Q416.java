package com.leetcode.动态规划.背包01;

public class Q416 {
    /**
     * boolean
     * com.leetcode.动态规划
     * 二维矩阵
     * 状态转移方程:dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]]
     * dp[i][j]代表nums[]中，前i个数字是否可以组成成值为j
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }
        if (sum % 2 != 0)
            return false;
        int middle = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][middle + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= middle; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][middle];
    }

    /**
     * 空间优化，采用一维矩阵
     *
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }
        if (sum % 2 != 0)
            return false;
        int middle = sum / 2;
        boolean[] dp = new boolean[middle + 1];
        dp[0] = true;
        for (int number : nums) {
            for (int i = middle; i >= number; i--) {
                dp[i] = dp[i] || dp[i - number];
            }
        }
        return dp[middle];
    }
}
