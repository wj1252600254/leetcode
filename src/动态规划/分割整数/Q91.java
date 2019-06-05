package 动态规划.分割整数;

public class Q91 {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            //i-1是真正的位置
            if (s.charAt(i - 2) == '0')
                continue;
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two > 0 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
