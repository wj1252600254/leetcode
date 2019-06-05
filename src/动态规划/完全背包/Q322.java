package 动态规划.完全背包;

public class Q322 {
    /**
     * 完全背包问题只需将0-1背包逆序遍历改为正序遍历即可
     * 无限的物品
     * 最少问题
     * dp[i]==0意味着不能拼凑成i元
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i == coin) {
                    dp[i] = 1;
                    //为何dp[i - coin] != 0
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    /**
     * 根据279题得出的一个想法
     */
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) {
                    break;
                } else {
                    min = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
            dp[i] = min;
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }


}
