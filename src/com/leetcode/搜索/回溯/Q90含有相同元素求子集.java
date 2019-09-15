package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重复，位置无关，一次
 */
public class Q90含有相同元素求子集 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0)
            return lists;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++)
            dfs(nums, new ArrayList<>(), lists, 0, i, new boolean[nums.length]);
        return lists;
    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> lists, int start, int size, boolean[] booleans) {
        if (list.size() == size) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !booleans[i - 1])
                continue;
            list.add(nums[i]);
            booleans[i] = true;
            dfs(nums, list, lists, i + 1, size, booleans);
            booleans[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
