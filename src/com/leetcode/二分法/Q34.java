package com.leetcode.二分法;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int start = binarySearch(nums, target);
        int end = binarySearch(nums, target + 1) - 1;
//        if (start == 0 && nums[start] != target)
//            start = -1;
//        if (end == nums.length - 1 && nums[nums.length - 1] == target)
//            end = nums.length;
//        return new int[]{start, end - 1};
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        } else {
            //last可能为负值，因为如果说target+1<nums[0]，那么last取值为-1,不可能！！！！！！！！！！！！可以不加
            return new int[]{start, Math.max(start, end)};
        }
    }

    private int binarySearch(int[] nums, int target) {
        //h的初始值
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
