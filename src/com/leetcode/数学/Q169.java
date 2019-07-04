package com.leetcode.数学;

public class Q169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 0)
            return -1;
        int res = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0)
                res = num;
            if (res == num) {
                count++;
            } else
                count--;
        }
        return res;
    }
}
