package com.leetcode.搜索.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q417 {
    boolean[][] a;
    boolean[][] b;
    int m, n;
    int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return list;
        m = matrix.length;
        n = matrix[0].length;
        a = new boolean[m][n];
        b = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, a);
            dfs(matrix, i, n - 1, b);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, a);
            dfs(matrix, m - 1, i, b);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] && b[i][j])
                    list.add(new int[]{i, j});
            }
        }
        return list;
    }

    private void dfs(int[][] ma, int i, int j, boolean[][] b) {
        //只是为了减少重复的步骤
        if (b[i][j])
            return;
        b[i][j] = true;
        for (int[] t : direction) {
            int ni = i + t[0];
            int nj = j + t[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n || ma[ni][nj] > ma[i][j])
                continue;
            dfs(ma, ni, nj, b);
        }
    }

}
