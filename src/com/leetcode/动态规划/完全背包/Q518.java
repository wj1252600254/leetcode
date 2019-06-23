package com.leetcode.动态规划.完全背包;

public class Q518 {
    /**可以和      Q494对比
     * 完全背包组合数问题
      * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
