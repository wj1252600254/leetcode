package com.leetcode.贪心思想;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int max =Integer.MIN_VALUE;
        int cur = 0;
        for (int t : nums) {
            cur += t;
            max = Math.max(cur, max);
            if (cur < 0) {
                cur = 0;
                continue;
            }

        }
        return max;
    }
}
