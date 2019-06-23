package com.leetcode.动态规划.最长递增子序列;

import java.util.Arrays;

public class Q300 {
    /**
     * 空间复杂度为O(n2)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int max = 1;
            for (int j = 0; j < len; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    /**
     * 空间复杂度为nlogn
     * 原理：从前往后遍历，通过二分法找最长子序列
     * tails      len      num
     * []         0        4
     * [4]        1        3
     * [3]        1        6
     * [3,6]      2        5
     * [3,5]      2        null
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int len = 0, length = nums.length;
        int[] tails = new int[length];
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] nums, int len, int key) {
        int l = 0, h = len;
        while (l < h) {
            int medium = l + (h - l) / 2;
            if (nums[medium] == key) {
                return medium;
            } else if (nums[medium] > key) {
                h = medium;
            } else {
                l = medium + 1;
            }
        }
        return l;
    }
}
