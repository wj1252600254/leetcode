package com.leetcode.树.递归;

import com.TreeNode;

public class Q437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //值得推敲
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == sum)
            ret++;
        ret += dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
        return ret;
    }
}
