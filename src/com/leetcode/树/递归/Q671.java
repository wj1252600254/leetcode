package com.leetcode.树.递归;

import com.TreeNode;

public class Q671 {


    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null)
            return -1;
        int val = root.val;
        int left = root.left.val;
        int right = root.right.val;
        if (val == left) left = findSecondMinimumValue(root.left);
        if (val == right) right = findSecondMinimumValue(root.right);
        if (left != -1 && right != -1) return Math.min(left, right);
        if (left != -1) return left;
        return right;
    }
}
