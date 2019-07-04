package com.leetcode.树.bst;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q530 {
    /**
     * 直接在dfs中，处理
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int min = Integer.MAX_VALUE;
        int size = list.size();
        int diff = 0;
        for (int i = 1; i < size; i++) {
            diff = list.get(i) - list.get(i - 1);
            min = Math.min(min, diff);
        }
        return min;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
