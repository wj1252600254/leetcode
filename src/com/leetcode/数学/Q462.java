package com.leetcode.数学;

import java.util.Arrays;

public class Q462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0, h = nums.length - 1;
        int count = 0;
        while (l <= h) {
            count += nums[h] - nums[l];
            l++;
            h--;
        }
        return count;
    }
}
