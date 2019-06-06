package 动态规划.字符串编辑;

public class Q650 {
    /**
     * https://blog.csdn.net/zw159357/article/details/82823840
     * 动态规划
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        if (n == 1)
            return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= (int) (Math.sqrt(i)); j++) {
                if (i % j == 0)
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
            }
        }
        return dp[n];
    }

    /**
     * 实际上是求约数的最小个数
     * 9   3*3 3*1   res  0+3  3+3
     * 8  2*4  2*2  2*1    res   2   2+2
     *
     * @param n
     * @return
     */
    public int f(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n = n / i;
            }
        }
        return res;
    }
}
