package com.leetcode.搜索.dfs;

public class Q200矩阵中的连通分量数目 {
    int cnt = 0;
    int m, n;
    int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(grid, i, j))
                    cnt++;
            }
        }
        return cnt;

    }

    private boolean dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0')
            return false;
        grid[i][j] = '0';
        for (int[] t : direction) {
            dfs(grid, i + t[0], j + t[1]);
        }
        return true;
    }
}
