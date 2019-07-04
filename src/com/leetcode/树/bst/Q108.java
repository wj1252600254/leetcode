package com.leetcode.树.bst;

import com.TreeNode;

public class Q108 {
    //循环不变式
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int beg, int end) {
        if (end < beg)
            return null;
        int mid = (beg + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, beg, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }
}
