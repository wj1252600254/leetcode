package com.leetcode.搜索.回溯;

public class Q79 {
    int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int m, n;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, mark, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] mark, String word, int i, int j, int curlen) {
        if (curlen == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(curlen) != board[i][j] || mark[i][j])
            return false;
        mark[i][j] = true;
        for (int[] t : direction) {
            if (dfs(board, mark, word, i + t[0], j + t[1], curlen + 1))
                return true;
        }
        mark[i][j] = false;
        return false;
    }
}
