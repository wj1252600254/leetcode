package com.leetcode.树.递归;

import com.TreeNode;

public class Q337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val, val2);
    }
}
