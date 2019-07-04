package com.leetcode.搜索.dfs;

public class Q547 {
    int m;

    public int findCircleNum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        m = grid.length;
        int cnt = 0;
        boolean[] marked = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (marked[i]) {
                dfs(grid, i, marked);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int[][] grid, int i, boolean[] marked) {
        marked[i] = true;

        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1 && !marked[j]) {
                dfs(grid, j, marked);
            }
        }
    }
}
