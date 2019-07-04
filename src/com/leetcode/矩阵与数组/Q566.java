package com.leetcode.矩阵与数组;

public class Q566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int[][] ans = new int[r][c];
        int rl = 0, cl = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = nums[rl][cl];
                cl++;
                if (cl >= col) {
                    cl = 0;
                    rl++;
                }
            }
        }
        return ans;
    }
}
