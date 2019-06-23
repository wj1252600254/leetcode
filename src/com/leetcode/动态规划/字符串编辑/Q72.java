package com.leetcode.动态规划.字符串编辑;

public class Q72 {
    /**
     * dp[i][j]代表word1前i个与word2前j个的最小变换步数
     * replace word1[i] with word2[j] (dist[i - 1][j - 1] + 1)
     * delete word1[i] (dist[i - 1][j] + 1)
     * delete word2[j] (dist[i][j - 1] + 1)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //将word1删除需要的次数
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        //将word2删除需要的次数
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //dp[i][j] = Min(delete,add,change) + 1
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
