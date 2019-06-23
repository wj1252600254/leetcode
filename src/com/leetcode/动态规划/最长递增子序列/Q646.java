package com.leetcode.动态规划.最长递增子序列;

import java.util.Arrays;

public class Q646 {
    /**
     * 和300相似
     * dp[i]代表
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
