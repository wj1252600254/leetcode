package com.leetcode.树.递归;

import com.TreeNode;

public class Q687 {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftl = dfs(root.left);
        int rightl = dfs(root.right);
        int l = (root.left != null && root.val == root.left.val) ? leftl + 1 : 0;
        int r = (root.right != null && root.val == root.right.val) ? rightl + 1 : 0;
        max = Math.max(max, l + r);
        return Math.max(l, r);
    }
}
