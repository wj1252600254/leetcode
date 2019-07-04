package com.leetcode.矩阵与数组;

public class Q766 {
    int row;
    int col;

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (!check(matrix, i, 0)) {
                return false;
            }
        }
        for (int i = 0; i < col; i++) {
            if (!check(matrix, 0, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] ma, int m, int n) {
        int pre = ma[m][n];
        for (int i = m, j = n; i < row && j < col; i++, j++) {
            if (pre != ma[i][j]) {
                return false;
            }
        }
        return true;
    }
}
