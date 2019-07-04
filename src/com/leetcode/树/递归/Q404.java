package com.leetcode.树.递归;

import com.TreeNode;

public class Q404 {
//    private int sum;
//
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left != null) {
//            sum += root.left.val;
//        }
//        sumOfLeftLeaves(root.left);
//        sumOfLeftLeaves(root.right);
//        return sum;
//    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root.left))
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
