package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和位置有关，但有重复数字
 */
public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0)
            return lists;
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(int[] nums, boolean[] booleans, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //防止重复
            if (i != 0 && nums[i] == nums[i - 1] && !booleans[i - 1])
                continue;
            if (booleans[i])
                continue;
            booleans[i] = true;
            list.add(nums[i]);
            dfs(nums, booleans, list, lists);
            list.remove(list.size() - 1);
            booleans[i] = false;
        }
    }
}
