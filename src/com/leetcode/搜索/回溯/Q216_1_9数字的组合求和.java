package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 用一次，位置无关，不含重复元素
 */
public class Q216_1_9数字的组合求和 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        if (k == 0 || n == 0)
            return lists;
        dfs(k, n, 1, lists, new ArrayList<>());
        return lists;
    }

    private void dfs(int k, int n, int start, List<List<Integer>> lists, List<Integer> list) {
        if (k == 0 || n == 0) {
            if (k == 0 && n == 0) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i <= n) {
                list.add(i);
                //是i，不是start
                dfs(k - 1, n - i, i + 1, lists, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
