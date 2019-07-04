package com.leetcode.矩阵与数组;

public class Q769 {
    public int maxChunksToSorted(int[] arr) {
        int ret = 0;
        int right = arr[0];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            right = Math.max(arr[i], right);
            if (right == i) {
                ret++;
            }
        }
        return ret;
    }
}
