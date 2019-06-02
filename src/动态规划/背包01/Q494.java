package 动态规划.背包01;

public class Q494 {
    /**
     * 方法数
     * 动态规划二维数组
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     * 2 * sum(P) = target + sum(nums)
     * 状态转移方程：dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
     * dp[i][j]代表前i个数中可以组成值为j的种数。
     * 时间复杂度O(N*M)
     * 空间复杂度O(N*M)
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = sun(nums);
        if (sum < S || (S + sum) % 2 != 0)
            return 0;
        int positive = (S + sum) / 2;
        int[][] dp = new int[nums.length + 1][positive + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= positive; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][positive];
    }


    /**
     * 空间优化版本,  Q518
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays1(int[] nums, int S) {
        int sum = sun(nums);
        if (sum < S || (S + sum) % 2 != 0)
            return 0;
        int positive = (S + sum) / 2;
        int[] dp = new int[positive + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = positive; i >= n; i--) {
                dp[i] = dp[i] + dp[i - n];
            }
        }
        return dp[positive];
    }

    public int sun(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }
}
