package com.leetcode.矩阵与数组;

public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int l = matrix[0][0], h = matrix[m - 1][n - 1];

        while (l < h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
