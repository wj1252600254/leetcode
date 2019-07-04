package com.leetcode.矩阵与数组;

public class Q485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
                max = Math.max(max, cnt);
            }else {
                cnt = 0;
            }
        }
        return max;
    }
}
