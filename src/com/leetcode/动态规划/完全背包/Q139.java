package com.leetcode.动态规划.完全背包;

import java.util.List;

public class Q139 {
    /**
     * 求解顺序的完全背包问题时，对物品的迭代应该放在最里层
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (String word : wordDict) {
                int n = word.length();
                if (n <= i && word.equals(s.substring(i - n, i))) {
                    dp[i] |= dp[i - n];
                }
            }
        }
        return dp[len];
    }
}
