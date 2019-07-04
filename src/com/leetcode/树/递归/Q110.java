package com.leetcode.树.递归;

import com.TreeNode;

public class Q110 {

    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        if (Math.abs(left - right) > 1)
            res = false;
        return Math.max(left, right);
    }
}
