package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 和位置有关，无重复数字
 */
public class Q46 {
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0)
            return lists;
        dfs(nums, lists, new ArrayList<>());
        return lists;
    }

    //可以直接用list是否包含数字来判断，可以降低试驾复杂度和空间复杂度，但在超级大的数据量的情况下，本方案更优
    private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int t : nums) {
            if (set.contains(t))
                continue;
            list.add(t);
            set.add(t);
            dfs(nums, lists, list);
            list.remove(list.size() - 1);
            set.remove(t);
        }
    }
}
