package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和位置无关，只能用一次。39,77
 * 含重复元素47
 */
public class Q40含有相同元素的组合求和 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length == 0)
            return lists;
        //含重复元素的一般处理方式
        Arrays.sort(candidates);
        dfs(candidates, lists, new ArrayList<>(), 0, target, new boolean[candidates.length]);
        return lists;
    }

    private void dfs(int[] candidates, List<List<Integer>> lists, List<Integer> list, int start, int target, boolean[] booleans) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //含重复数字的特殊处理
            if (i != 0 && candidates[i] == candidates[i - 1] && !booleans[i - 1])
                continue;
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                booleans[i] = true;
                dfs(candidates, lists, list, i + 1, target - candidates[i], booleans);
                booleans[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
