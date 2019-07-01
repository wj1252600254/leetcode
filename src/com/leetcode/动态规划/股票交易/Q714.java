package com.leetcode.动态规划.股票交易;

public class Q714 {
    public static void main(String[] args) {
        new Q714().maxProfit(new int[]{1,3,2,8,4,9},2);
    }
    /**
     * buy[i]=Math.max(buy[i-1],sell[i-1]-price[i]-fee)
     * sell[i]=Math.max(sell[i-1],buy[i-1]-fee+price[i])
     *为考虑空间优化
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
//        int[] buy = new int[prices.length];
//        int[] sell = new int[prices.length];
//        buy[0] = -prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
//            sell[i] = Math.max(sell[i - 1], buy[i - 1] - fee + prices[i]);
//        }
        int bu=Integer.MIN_VALUE;
        int prebu=0;
        int sel=0;
        for (int i = 0; i < prices.length; i++) {
            prebu=bu;
            bu = Math.max(bu, sel - prices[i]);
            //发生溢出
            sel = Math.max(sel, prebu - fee + prices[i]);
        }
        return sel;
//        return sell[prices.length - 1];
    }
}
