package com.leetcode.树.bst;

import com.TreeNode;

public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > q.val && root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < q.val && root.val < p.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
