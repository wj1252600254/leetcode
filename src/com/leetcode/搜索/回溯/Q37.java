package com.leetcode.搜索.回溯;

public class Q37 {
    public static void main(String[] args) {
        System.out.println(1 / 3 * 3);
    }

    //之所以取到10,是因为数字1~9，9这个数字会放在第10格
    private boolean[][] row = new boolean[9][10];
    private boolean[][] col = new boolean[9][10];
    private boolean[][] cube = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                row[i][num] = true;
                col[j][num] = true;
                cube[cubeCnt(i, j)][num] = true;
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int rows, int cols) {
        while (rows < 9 && board[rows][cols] != '.') {
            rows = cols == 8 ? rows + 1 : rows;
            cols = cols == 8 ? 0 : cols + 1;
        }
        if (rows == 9)
            return true;
        for (int i = 1; i <= 9; i++) {
            if (row[rows][i] || col[cols][i] || cube[cubeCnt(rows, cols)][i])
                continue;
            row[rows][i] = col[cols][i] = cube[cubeCnt(rows, cols)][i] = true;
            board[rows][cols] = (char) (i + '0');
            //仔细想想，如果返回值为true   79,
            if (dfs(board, rows, cols))
                return true;
            row[rows][i] = col[cols][i] = cube[cubeCnt(rows, cols)][i] = false;
            board[rows][cols] = '.';
        }
        return false;
    }

    private int cubeCnt(int roe, int col) {
        return roe / 3 * 3 + col / 3;
    }
}
