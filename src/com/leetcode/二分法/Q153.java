package com.leetcode.二分法;

public class Q153 {
    /**
     * 观察数组特性，可以将mid与两侧的数做对比
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, h = len - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= nums[h])
                h = mid;
            else
                l = mid + 1;
        }
        return nums[l];
    }
}
