package com.leetcode.双指针;

public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1, h = n - 1, end = m + n - 1;
        while (l >= 0 || h >= 0) {
            if (l < 0) {
                nums1[end--] = nums2[h--];
            } else if (h < 0) {
                nums1[end--] = nums1[l--];
            } else if (nums1[l] <= nums2[h]) {
                nums1[end--] = nums2[h--];
            } else {
                nums1[end--] = nums1[l--];
            }
        }
    }
}
