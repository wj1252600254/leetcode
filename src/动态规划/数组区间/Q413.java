package 动态规划.数组区间;

public class Q413 {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if (len < 3)
            return 0;
        int[] dp = new int[len];
        int con = 0;
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                con += 1;
                dp[i] = dp[i - 1] + con;
            } else {
                con = 0;
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}
