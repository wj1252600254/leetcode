package com.leetcode.树.递归;

import com.TreeNode;

public class Q572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null)
            return false;
        if (s.val == t.val && isEqual(s, t))
            return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null)
            return false;
        if (t2 == null)
            return false;
        if (t1.val == t2.val)
            return isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
        else
            return false;
    }
}
