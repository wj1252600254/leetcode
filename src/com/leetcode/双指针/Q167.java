package com.leetcode.双指针;

public class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 0)
            return new int[]{-1, -1};
        int l = 0, h = numbers.length - 1;
        int sum = 0;
        while (l < h) {
            sum = numbers[l] + numbers[h];
            if (sum == target) {
                return new int[]{l+1, h+1};
            } else if (sum < target) {
                l++;
            } else if (sum > target) {
                h--;
            }
        }
        return new int[]{-1, -1};
    }
}
