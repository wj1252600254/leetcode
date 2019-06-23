package com.leetcode.动态规划.完全背包;

public class Q377 {

    /**
     * 完全背包求方法种数
     * 有顺序
     *和Q518相比，只是把对物品的遍历放内层了
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
