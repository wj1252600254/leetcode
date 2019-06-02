package 动态规划.股票交易;

public class Q123 {
    /**
     * https://blog.csdn.net/u014609111/article/details/53508905
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int[] pre = new int[prices.length];
        int[] post = new int[prices.length];
        int min = prices[0];
        int max = prices[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            pre[i] = Math.max(prices[i] - min, pre[i - 1]);
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            post[i] = Math.max(max - prices[i], post[i + 1]);
        }
        int maxprofit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxprofit = Math.max(maxprofit, pre[i] + post[i]);
        }
        return maxprofit;
    }
}
