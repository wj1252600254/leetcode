package com.leetcode.搜索.dfs;

public class Q695 {
    int m, n;
    int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                area = Math.max(area, dfs(grid, i, j));
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int area = 1;
        for (int[] t : direction) {
            area += dfs(grid, i + t[0], j + t[1]);
        }
        return area;
    }
}
