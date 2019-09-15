package com.leetcode.贪心思想;

public class Q121买卖股票最大的收益 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int diff = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                diff = Math.max(diff, prices[i] - min);
            }
            min = Math.min(min, prices[i]);
        }
        return diff;
    }
}
