package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字可以无限使用，和位置无关
 */
public class Q39组合求和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length == 0)
            return lists;
        dfs(candidates, lists, new ArrayList<>(), target, 0, 0);
        return lists;
    }

    private void dfs(int[] cadidates, List<List<Integer>> lists, List<Integer> list, int targte, int sum, int start) {
        //每次dfs都会判断两次
        if (sum >= targte) {
            if (sum == targte) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i < cadidates.length; i++) {
            int t = cadidates[i];
            sum += t;
            list.add(t);
            //关键   数字可以无限用
            dfs(cadidates, lists, list, targte, sum, i);
            list.remove(list.size() - 1);
            sum -= t;
        }
    }
}
