package com.leetcode.二分法;

public class Q540 {
    /**
     * 如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int l = 0, h = len - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (mid % 2 == 1)
                mid--;
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }
}
