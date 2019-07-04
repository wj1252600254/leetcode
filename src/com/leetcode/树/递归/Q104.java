package com.leetcode.树.递归;

import com.TreeNode;

public class Q104 {
    public int maxDepth(TreeNode root) {
        return dfs(0, root);
    }

    private int dfs(int cnt, TreeNode root) {
        if (root == null)
            return cnt;
        return Math.max(dfs(cnt + 1, root.left), dfs(cnt + 1, root.right));
    }
}
