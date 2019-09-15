package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 不重复，位置无关，一次
 */
public class Q78子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, new ArrayList<>(), lists, 0, i);
        }
        return lists;
    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> lists, int start, int size) {
        if (list.size() == size) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, lists, i + 1, size);
            list.remove(list.size() - 1);
        }
    }
}
