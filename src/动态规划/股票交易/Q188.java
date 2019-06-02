package 动态规划.股票交易;

import java.util.Arrays;

public class Q188 {
    /**
     * 当k>prices.length/2时，就是可以交易任意次最大利润
     * 1.第k次buy就是 上一次卖出剩下的钱 - 本次购买需要的钱
     * 2.第k次sell就是 第k次买入 + 本次卖出的钱
     * <p>
     * buy[j] = max(buy[j], sell[j-1] - prices[i])
     * sell[j] = max(sell[j], buy[j] + prices[i])
     *卖出的钱不可能是负的
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2)
            return 0;
        int len = prices.length;
        int maxProfit = 0;
        if (k >= len / 2) {
            int diff = 0;
            for (int i = 1; i < len; i++) {
                if ((diff = prices[i] - prices[i - 1]) > 0) {
                    maxProfit += diff;
                }
            }
            return maxProfit;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }
}
