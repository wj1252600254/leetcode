package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

public class Q51 {

    char[][] res;
    boolean[] b45;
    boolean[] col;
    boolean[] b135;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        if (n < 1)
            return lists;
        res = new char[n][n];
        b45 = new boolean[2 * n - 1];
        col = new boolean[n];
        b135 = new boolean[2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = '.';
            }
        }
        dfs(0, n, lists);
        return lists;
    }
    private void dfs(int row, int n, List<List<String>> lists) {
        if (row == n) {
            List<String> strings = new ArrayList<>();
            for (char[] chars : res) {
                strings.add(new String(chars));
            }
            lists.add(strings);
            return;
        }
        for (int i = 0; i < n; i++) {
            int c45 = i + row;
            int c135 = n - 1 - (row - i);
            if (b135[c135] || b45[c45] || col[i])
                continue;
            res[row][i] = 'Q';
            b45[c45] = b135[c135] = col[i] = true;
            dfs(row + 1, n, lists);
            res[row][i] = '.';
            b45[c45] = b135[c135] = col[i] = false;
        }
    }

}
