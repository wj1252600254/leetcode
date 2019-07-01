package com.leetcode.动态规划.数组区间;

public class Q303 {
    int[] nums;
    int[] dp;

    public Q303(int[] nums) {
        if (nums.length==0)
            return;
        this.nums = nums;
        //-----------------------------
        dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    /**
     * 每次调用都必须重新计算
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        int res = 0;
        for (int m = i; m <= j; m++) {
            res += nums[m];
        }
        return res;
    }

    /**
     * 使用动态规划
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange1(int i, int j) {

        return dp[j] - dp[i] +  nums[i];
    }

}
