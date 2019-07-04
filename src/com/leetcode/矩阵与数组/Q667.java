package com.leetcode.矩阵与数组;

public class Q667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1, diff = k; i <= k; i++, diff--) {
            ans[i] = i % 2 == 1 ? ans[i - 1] + diff : ans[i - 1] - diff;
        }
        for (int i = k + 1; i < n; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
