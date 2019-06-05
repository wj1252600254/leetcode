package 动态规划.分割整数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q279 {
    /**
     * 求出完全平方数的组合，然后转化为完全背包问题
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (Integer temp : squareList) {
            for (int i = temp; i <= n; i++) {
                if (temp == i) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - temp] != 0) {
                    dp[i] = dp[i - temp] + 1;
                } else if (dp[i - temp] != 0) {
                    dp[i] = Math.min(dp[i - temp] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }

    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }

    /**
     * 优化解
     */
    public int numSquares1(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        int i = 0;
        while (++i * i <= n) {
            for (int j = i * i; j < memo.length; j++) {
                memo[j] = Math.min(memo[j], memo[j - (i * i)] + 1);
            }
        }
        return memo[n];
    }
}
