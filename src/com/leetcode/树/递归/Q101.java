package com.leetcode.树.递归;

import com.TreeNode;

public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSys(root.left, root.right);
    }

    private boolean isSys(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return isSys(t1.left, t2.right) && isSys(t1.right, t2.left);
    }
}
