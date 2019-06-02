package 动态规划.股票交易;

public class Q714 {
    /**
     * buy[i]=Math.max(buy[i-1],sell[i-1]-price[i]-fee)
     * sell[i]=Math.max(sell[i-1],buy[i-1]-fee+price[i])
     *为考虑空间优化
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] - fee + prices[i]);
        }
        return sell[prices.length - 1];
    }
}
