package com.leetcode.贪心思想;

public class Q665修改一个数成为非递减数组 {
    public static void main(String[] args) {
        System.out.println(new Q665修改一个数成为非递减数组().checkPossibility(new int[]{4, 2, 1}));
    }

    public boolean checkPossibility(int[] nums) {
        if (nums.length < 2)
            return true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i < nums.length - 1 && nums[i + 1] < nums[i - 1]) {
                    nums[i - 1] = i == 1 ? nums[i] : nums[i - 2];
                    return isValid(nums, i);
                } else {
                    nums[i] = nums[i - 1];
                    return isValid(nums, i);
                }
            }
        }
        return true;
    }

    private boolean isValid(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                return false;
        }
        return true;
    }
}
