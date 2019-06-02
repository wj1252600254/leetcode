package 动态规划.多维背包;

public class Q474 {
    /**
     * 多维0-1背包
     * 状态转移方程：dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
     * dp[i][j];代表数组中可以组成i个0，j个1的最大个数
     * 空间优化后的方法，主要在于逆序
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 采用正序
     * 不优化版本
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm1(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int zeros = 0;
            int ones = 0;
            for (char c : strs[i - 1].toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < n; k++) {
                    if (j < zeros || k < ones) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
