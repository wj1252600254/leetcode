package com.leetcode.动态规划.分割整数;

public class Q343 {
    /**
     * 剪绳子问题，求最长
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        //
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                //每一轮有i-1个dp[i]，取出其中的最大值
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    public int integerBreak1(int n) {
        if (n <= 3) return n - 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                //每一轮有i-1个dp[i]，取出其中的最大值
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
