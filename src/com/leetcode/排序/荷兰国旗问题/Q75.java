package com.leetcode.排序.荷兰国旗问题;

public class Q75 {

    /**
     * 无话可说
     *如果是4色的国旗捏  不会
     * 两色国旗
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, one, --two);
            } else {
                one++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
