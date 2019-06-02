package 动态规划.股票交易;

public class Q309 {
    /**
     * https://blog.csdn.net/Dr_Unknown/article/details/51939121
     * 交易之后需要有一天的冷却时间。
     * sell[i]代表第i天一定会卖出
     * cooldown[i]代表第i天冷却，说明第i-1天卖出了
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int len = prices.length;
        int[] sells = new int[len];
        int[] cooldown = new int[len];
        sells[1] = prices[1] - prices[0];
        for (int i = 2; i < len; i++) {
            cooldown[i] = Math.max(sells[i - 1], cooldown[i - 1]);
            sells[i] = prices[i] - prices[i - 1] + Math.max(sells[i - 1], cooldown[i - 2]);
        }
        return Math.max(sells[len - 1], cooldown[len - 1]);
    }

    /**
     * ADASDASD
     * 一共有4个状态
     * buy[i]代表第i个买入
     * s1[i]代表不卖
     * s2[i]代表不买
     * sell[i]代表第i天卖出去
     *
     * @param prices
     * @return
     */

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int N = prices.length;
        int[] buy = new int[N];
        int[] s1 = new int[N];
        int[] sell = new int[N];
        int[] s2 = new int[N];
        s1[0] = buy[0] = -prices[0];
        sell[0] = s2[0] = 0;
        for (int i = 1; i < N; i++) {
            buy[i] = s2[i - 1] - prices[i];
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);
            sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i];
            s2[i] = Math.max(s2[i - 1], sell[i - 1]);
        }
        return Math.max(sell[N - 1], s2[N - 1]);
    }

    /**
     * buy[i]  = max(rest[i-1] - price, buy[i-1])   看第i天有没有买
     * sell[i] = max(buy[i-1] + price, sell[i-1])    看第i天有没有卖 i-1那天不可能是冷却，也不可能是卖
     * rest[i] = max(sell[i-1], buy[i-1], rest[i-1])   看第i天有没有冷却
     */
    public int maxProfit2(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0, pre_sell = 0, pre_buy = 0;
        for (int i = 0; i < prices.length; i++) {
            pre_buy = buy;
            buy = Math.max(pre_sell - prices[i], pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + prices[i], pre_sell);
        }
        return sell;
    }
}
