package com.leetcode.树.递归;

import com.TreeNode;

/**
 * 687
 */
public class Q543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    /**
     * 改递归方法的意思是返回的最长长度
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
