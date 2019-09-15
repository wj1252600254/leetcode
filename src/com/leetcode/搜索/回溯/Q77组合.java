package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 和位置无关,数字只能用一次
 * 和39对比
 */
public class Q77组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        if (n < 1 || k < 1)
            return lists;
        dfs(lists, new ArrayList<>(), k, 1, n);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, List<Integer> list, int k, int start, int n) {
        if (k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        //剪枝  和位置无关
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            //数字只能用一次
            dfs(lists, list, k - 1, i + 1, n);
            list.remove(list.size() - 1);
        }
    }
}
